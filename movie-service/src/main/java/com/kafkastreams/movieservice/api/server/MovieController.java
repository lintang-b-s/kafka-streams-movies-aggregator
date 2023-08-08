package com.kafkastreams.movieservice.api.server;

import com.kafkastreams.movieservice.api.request.AddMovieReq;
import com.kafkastreams.movieservice.api.response.Movie;
import com.kafkastreams.movieservice.command.service.MovieCommandService;
import com.kafkastreams.movieservice.util.DtoMapper.MovieDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/movie-service/movies")
@AllArgsConstructor
public class MovieController {
    private MovieDtoMapper mapper;
    private MovieCommandService movieService;



    @PostMapping
    public ResponseEntity<Movie> addMoviesWithVideo(@RequestBody AddMovieReq newMovie) {

        return ok(mapper.movieEntitytoMovieDto(movieService.addMovie(newMovie)));
    }



    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable(value = "movieId") int movieId, @RequestBody AddMovieReq updateMovie) {
        return ok(mapper.movieEntitytoMovieDto(movieService.updateMovie(movieId, updateMovie)));
    }



    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovieById(@PathVariable("movieId") int movieId) {
        return ok(movieService.deleteMovie(movieId));
    }



}
