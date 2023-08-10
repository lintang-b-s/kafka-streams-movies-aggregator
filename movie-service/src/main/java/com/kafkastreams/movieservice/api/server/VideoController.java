package com.kafkastreams.movieservice.api.server;


import com.kafkastreams.movieservice.api.request.UpdateVideoReq;
import com.kafkastreams.movieservice.command.service.VideoCommandService;
import com.kafkastreams.movieservice.util.DtoMapper.VideoDtoMapper;
import com.kafkastreams.movieservice.api.request.AddVideoReq;
import com.kafkastreams.movieservice.api.response.Video;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/movie-service/videos")
public class VideoController {
    private VideoDtoMapper mapper;
    private VideoCommandService videoService;


    @Autowired
    public VideoController(VideoDtoMapper mapper, VideoCommandService videoService) {
        this.mapper = mapper;
        this.videoService = videoService;
    }


    @PostMapping
    public ResponseEntity<Video> save(@RequestBody AddVideoReq newVideo) {
        return ok(mapper.videoEntitySavetoVideoDto(videoService.save(newVideo)));
    }

    @PostMapping("/add")
    public ResponseEntity<Video> addVideoByMovie(@RequestBody AddVideoReq newVideo) {
        return ok(mapper.videoEntityToVideoDto(videoService.addVideoByMovieId(newVideo)));

    }

    @PostMapping("/addUpload")
    public ResponseEntity<Video> addVideoAndUpload(@RequestParam("file") MultipartFile file,
            @RequestBody AddVideoReq newVideo) {
        return ok(mapper.videoEntityToVideoDto(videoService.addVideoAndUpload(newVideo, file)));
    }



    @DeleteMapping("/{movieId}/{videoId}")
    public ResponseEntity<String> deleteVideoFromMovie(@PathVariable(value = "movieId") int movieId,
                                                      @PathVariable(value = "videoId") int videoId){
        return ok(videoService.deleteVideoFromMovie(movieId,videoId));
    }

    @PutMapping("/{movieId}/{videoId}")
    public ResponseEntity<Video> updateVideoFromMovie(@PathVariable(value = "movieId") int movieId,
                                                      @PathVariable(value = "videoId") int videoId,
                                                      UpdateVideoReq newVideo) {
        return ok(mapper.videoEntityToVideoDto(videoService.updateVideoFromMovie(movieId, videoId, newVideo)));
    }

}
