package com.kafkastreams.movieservice.command.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreams.movieservice.api.request.AddVideoReq;
import com.kafkastreams.movieservice.api.request.UpdateVideoReq;
import com.kafkastreams.movieservice.broker.message.AddVideoMessage;
import com.kafkastreams.movieservice.broker.message.DeleteVideoMessage;
import com.kafkastreams.movieservice.broker.message.UploadVideoMessage;
import com.kafkastreams.movieservice.broker.publisher.MediaPublisher;
import com.kafkastreams.movieservice.command.action.MovieOutboxAction;
import com.kafkastreams.movieservice.command.action.VideoCommandAction;
import com.kafkastreams.movieservice.entity.OutboxEntity;
import com.kafkastreams.movieservice.entity.OutboxEventType;
import com.kafkastreams.movieservice.entity.VideoEntity;
import com.kafkastreams.movieservice.exception.InternalServerEx;
import com.kafkastreams.movieservice.util.messageMapper.VideoMessageMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@NoArgsConstructor
@Service
public class VideoCommandService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoCommandService.class);

    private VideoCommandAction videoCommandAction;
    private VideoMessageMapper videoMessageMapper;
    private MovieOutboxAction outboxAction;
    private MediaPublisher mediaPublisher;

    @Autowired
    public VideoCommandService(VideoCommandAction videoCommandAction,
                               VideoMessageMapper videoMessageMapper,
                               MovieOutboxAction outboxAction,
                               MediaPublisher mediaPublisher) {
        this.videoCommandAction = videoCommandAction;
        this.videoMessageMapper = videoMessageMapper;
        this.outboxAction = outboxAction;
        this.mediaPublisher = mediaPublisher;
    }

    public VideoEntity save(@Valid AddVideoReq newVideo) {
        return videoCommandAction.saveReq(newVideo);
    }


    public Iterable<VideoEntity> getVideosByMovieId(@NotNull @Valid int movieId) {
        return videoCommandAction.getVideosByMovieId(movieId);
    }

    public void updateVideoUrl(String videoUrl, int videoId) {
        videoCommandAction.updateVideoUrl(videoUrl, videoId);
    }

    public VideoEntity addVideoAndUpload(@Valid AddVideoReq newVideo, MultipartFile file)  {
        VideoEntity video =  videoCommandAction.addVideoAndUpload(newVideo);
        byte[] fileByte = null;
        try {
             fileByte = file.getBytes();
        } catch (IOException e) {
        } catch (Exception ex) {
            throw new InternalServerEx("upload error: " + ex.getMessage());
        }

        UploadVideoMessage message = UploadVideoMessage.builder()
                .id(video.getId()).file(fileByte).publicId(UUID.randomUUID().toString())
                .build();


        mediaPublisher.publishToMediaService(message);
        return video;
    }

    public VideoEntity addVideoByMovieId( @Valid AddVideoReq newVideo) {
        VideoEntity video =  videoCommandAction.addVideoByMovieId(newVideo);
        AddVideoMessage videoMessage = videoMessageMapper.videoEntityToMessage(video);
        OutboxEntity videoOutbox = null;
        try{
            videoOutbox = outboxAction.insertOutbox(
                    "video.request",
                    String.valueOf(video.getId()),
                    OutboxEventType.ADD_VIDEO_TO_MOVIE, videoMessage
            );
        }catch (JsonProcessingException e) {
            throw new InternalServerEx("error json processing : " + e.getMessage());
        }
        outboxAction.deleteOutbox(videoOutbox);
        LOG.info("sending add_video_to_movie message with  id +  "+ String.valueOf(video.getId()) + " to movie-query-service!!" );
        return video;
    }


    public VideoEntity getVideoByMovieIdAndId(@NotNull @Valid int movieId,@NotNull @Valid int videoId) {
        return videoCommandAction.getVideoByMovieIdAndId(movieId, videoId);
    }



    @Transactional
    public String deleteVideoFromMovie(@NotNull @Valid int movieId, @NotNull @Valid int videoId) {
        videoCommandAction.deleteVideoFromMovie(movieId, videoId);
        DeleteVideoMessage message = DeleteVideoMessage.builder().id(videoId).build();
        OutboxEntity videoOutbox = null;
        try{
            videoOutbox = outboxAction.insertOutbox(
                    "video.request",
                    String.valueOf(videoId),
                    OutboxEventType.DELETE_VIDEO_FROM_MOVIE, message
            );
        }catch (JsonProcessingException e) {
            throw new InternalServerEx("error json processing : " + e.getMessage());
        }
        outboxAction.deleteOutbox(videoOutbox);
        LOG.info("sending delete_video_to_movie message with  id +  "+ String.valueOf(videoId) + " to movie-query-service!!" );

        return "movie deleted!";
    }


    @Transactional
    public VideoEntity updateVideoFromMovie(@NotNull @Valid int videoId,
                                                      @NotNull @Valid int movieId,
                                                      @Valid UpdateVideoReq newVideo){

       VideoEntity updatedVideo = videoCommandAction.updateVideoFromMovie(videoId, movieId, newVideo);

        AddVideoMessage videoMessage = videoMessageMapper.videoEntityToMessage(updatedVideo);
        OutboxEntity videoOutbox = null;
        try{
            videoOutbox = outboxAction.insertOutbox(
                    "video.request",
                    String.valueOf(updatedVideo.getId()),
                    OutboxEventType.UPDATE_VIDEO_FROM_MOVIE, videoMessage
            );
        }catch (JsonProcessingException e) {
            throw new InternalServerEx("error json processing : " + e.getMessage());
        }
        outboxAction.deleteOutbox(videoOutbox);
        LOG.info("sending update_video_to_movie message with  id +  "+ String.valueOf(updatedVideo.getId()) + " to movie-query-service!!" );
       return updatedVideo;
    }




}
