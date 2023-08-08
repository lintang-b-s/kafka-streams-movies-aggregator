package com.kafkastreams.movieservice.command.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreams.movieservice.command.action.MovieOutboxAction;
import com.kafkastreams.movieservice.api.request.AddMovieReq;
import com.kafkastreams.movieservice.broker.message.AddMovieMessage;
import com.kafkastreams.movieservice.broker.message.DeleteMovieMessage;
import com.kafkastreams.movieservice.broker.publisher.NotificationProducer;
import com.kafkastreams.movieservice.command.action.MovieCommandAction;
import com.kafkastreams.movieservice.entity.MovieEntity;
import com.kafkastreams.movieservice.entity.OutboxEntity;
import com.kafkastreams.movieservice.entity.OutboxEventType;
import com.kafkastreams.movieservice.exception.InternalServerEx;
import com.kafkastreams.movieservice.util.messageMapper.MovieMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class MovieCommandService {
    private static final Logger LOG = LoggerFactory.getLogger(MovieCommandService.class);


    @Autowired
    private MovieCommandAction movieCommandAction;

    @Autowired
    private MovieMessageMapper messageMapper;

    @Autowired
    private MovieOutboxAction outboxAction;

    @Autowired
    private NotificationProducer notificationProducer;

    public MovieCommandService(MovieCommandAction movieCommandAction) {
        this.movieCommandAction = movieCommandAction;
    }

    @Transactional
    public MovieEntity addMovie(@Valid AddMovieReq newMovie) {
        MovieEntity savedMovie = movieCommandAction.addMovie(newMovie);
        AddMovieMessage message= messageMapper.movieEntityToMessage(savedMovie);
        OutboxEntity movieOutbox=null;
        if (newMovie.getNotification()) {
            try {
                movieOutbox = outboxAction.insertOutbox(
                        "movie.request",
                        String.valueOf(savedMovie.getId()),
                        OutboxEventType.ADD_MOVIE,message
                );
            } catch (JsonProcessingException e) {
                throw new InternalServerEx("error json processing : " + e.getMessage());
            }
        }
        outboxAction.deleteOutbox(movieOutbox);
        LOG.info("sending add movie event with id " +  String.valueOf(savedMovie.getId()) + " to movie-query-service!" );
        notificationProducer.sendMessageEmail(message);
        LOG.info("sending add movie event with id " +  String.valueOf(savedMovie.getId()) + " to notification-service!" );
        return savedMovie;
    }

    @Transactional
    public MovieEntity updateMovie(int movieId, @Valid AddMovieReq newMovie) {
        MovieEntity updatedMovie = movieCommandAction.updateMovie( movieId ,newMovie);
        AddMovieMessage message= messageMapper.movieEntityToMessage(updatedMovie);
        OutboxEntity movieOutbox=null;
        try {
            movieOutbox = outboxAction.insertOutbox(
                    "movie.request",
                    String.valueOf(updatedMovie.getId()),
                    OutboxEventType.UPDATE_MOVIE,message
            );
        } catch (JsonProcessingException e) {
            throw new InternalServerEx("error json processing : " + e.getMessage());
        }
        outboxAction.deleteOutbox(movieOutbox);
        LOG.info("sending update_movie message with id " +  String.valueOf(updatedMovie.getId()) + " to movie-query-service!" );

        return updatedMovie;
    }


    @Transactional
    public String deleteMovie(int movieId) {
        String res=  movieCommandAction.deleteMovie( movieId);
        DeleteMovieMessage deleteMovieMessage = DeleteMovieMessage.builder()
                .id(movieId)
                .build();
        OutboxEntity movieOutbox=null;
        try {
            movieOutbox = outboxAction.insertOutbox(
                    "movie.request",
                    String.valueOf(deleteMovieMessage.getId()),
                    OutboxEventType.DELETE_MOVIE,deleteMovieMessage
            );
        } catch (JsonProcessingException e) {
            throw new InternalServerEx("error json processing : " + e.getMessage());
        }
        outboxAction.deleteOutbox(movieOutbox);
        LOG.info("sending delete_movie message with id " +  String.valueOf(deleteMovieMessage.getId()) + " to movie-query-service!" );

        return res;
    }



}
