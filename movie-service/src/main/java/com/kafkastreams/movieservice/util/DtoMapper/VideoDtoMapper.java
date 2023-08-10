package com.kafkastreams.movieservice.util.DtoMapper;

import com.kafkastreams.movieservice.api.response.Video;
import com.kafkastreams.movieservice.entity.VideoEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class VideoDtoMapper {
    public Video videoEntityToVideoDto(VideoEntity video) {
        Video videoDto = new Video(video.getId(), video.getUrl(), video.getPublicId(),
                video.getLength(), video.getTitle(), video.getSynopsis());
        return videoDto;
    }

    public Video videoEntitySavetoVideoDto(VideoEntity video) {
        Video videoDto = new Video(video.getId(), video.getUrl(), video.getPublicId(),
                video.getLength(), video.getTitle(), video.getSynopsis());
        return videoDto;
    }
    public List<Video> toListModel(Iterable<VideoEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false).map(e -> videoEntityToVideoDto(e))
                .collect(toList());
    }
}
