package com.kafkastreams.movieservice.command.action;


import com.kafkastreams.movieservice.api.request.AddVideoReq;
import com.kafkastreams.movieservice.api.request.UpdateVideoReq;
import com.kafkastreams.movieservice.entity.MovieEntity;
import com.kafkastreams.movieservice.entity.VideoEntity;
import com.kafkastreams.movieservice.repository.MovieRepository;
import com.kafkastreams.movieservice.repository.VideoRepository;
import com.kafkastreams.movieservice.util.entityMapper.VideoEntityMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class VideoCommandAction {

    private VideoRepository repository;
    private VideoEntityMapper mapper;
    private MovieRepository movieRepository;


    public VideoEntity save( AddVideoReq newVideo) {
        return repository.save(mapper.saveEntity(newVideo));
    }

    public Iterable<VideoEntity> getVideosByMovieId( int movieId) {
        return repository.findVideoEntitiesByMovieEntityId(movieId);
    }


    public VideoEntity addVideoByMovieId(  AddVideoReq newVideo) {
        MovieEntity movie = movieRepository.findById(newVideo.getMovieId()).get();
        return repository.save(mapper.toEntity(newVideo, movie));
    }

    public VideoEntity addVideoAndUpload(  AddVideoReq newVideo) {
        MovieEntity movie = movieRepository.findById(newVideo.getMovieId()).get();
        return repository.save(mapper.toEntityBeforeUpload(newVideo, movie));
    }


    public VideoEntity getVideoByMovieIdAndId( int movieId, int videoId) {
        return repository.getVideoEntitiesByMovie_IdAndId(movieId, videoId).get();
    }



    public void updateVideoUrl(String url, int videoID) {
        VideoEntity video = repository.findById(videoID).get();
        video.setUrl(url);
        repository.save(video);
        return ;
    }
    public String deleteVideoFromMovie( int movieId,  int videoId) {
        repository.deleteVideoEntitiesByMovie_IdAndId(movieId, videoId);
        return "movie deleted!";
    }


    public VideoEntity updateVideoFromMovie( int videoId,
                                             int movieId,
                                             UpdateVideoReq newVideo){

        MovieEntity movie = movieRepository.findById(movieId).get();
        MovieEntity newMovie = movieRepository.findById(Integer.parseInt(newVideo.getMovieId())).get();
        VideoEntity videoFromDb = repository.findById(videoId).get();
        videoFromDb.setUrl(newVideo.getUrl()).setLength(newVideo.getLength())
                .setTitle(newVideo.getTitle()).setSynopsis(newVideo.getSynopsis());


        if (Integer.parseInt(newVideo.getMovieId()) != videoFromDb.getMovie().getId()) {
            videoFromDb.setMovie(newMovie);
        }

        VideoEntity videoSaved = repository.save(videoFromDb);

        if (Integer.parseInt(newVideo.getMovieId()) != videoFromDb.getMovie().getId()) {
            movie.deleteVideo(videoFromDb);
            movieRepository.save(movie);
            newMovie.addMovie(videoFromDb);
            movieRepository.save(newMovie);
        }

        return videoSaved;

    }
}
