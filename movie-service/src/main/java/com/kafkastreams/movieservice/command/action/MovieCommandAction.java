package com.kafkastreams.movieservice.command.action;


import com.kafkastreams.movieservice.api.request.AddMovieReq;
import com.kafkastreams.movieservice.entity.*;
import com.kafkastreams.movieservice.exception.ResourceNotFoundException;

import com.kafkastreams.movieservice.query.action.*;
import com.kafkastreams.movieservice.repository.*;
import com.kafkastreams.movieservice.util.entityMapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class MovieCommandAction {

    private static final Logger LOG = LoggerFactory.getLogger(MovieCommandAction.class);



    private MovieRepository repository;

    private ActorEntityMapper actorEntityMapper;
    private CreatorEntityMapper creatorEntityMapper;
    private MovieEntityMapper movieEntityMapper;

    private VideoEntityMapper videoEntityMapper;

    private TagEntityMapper tagEntityMapper;

    private CategoryEntityMapper categoryEntityMapper;

    private ActorCommandAction actorCommandAction;
    private CreatorCommandAction creatorCommandAction;
    private TagCommandAction tagCommandAction;
    private CategoryCommandAction categoryCommandAction;
    private VideoCommandAction videoCommandAction;
    private ActorQueryAction actorQueryAction;
    private CreatorQueryAction creatorQueryAction;
    private TagQueryAction tagQueryAction;
    private CategoryQueryAction categoryQueryAction;
    private VideoQueryAction videoQueryAction;


    @Autowired
    public MovieCommandAction(MovieRepository repository,
                              ActorEntityMapper actorEntityMapper,
                              CreatorEntityMapper creatorEntityMapper,
                              MovieEntityMapper movieEntityMapper,
                              VideoEntityMapper videoEntityMapper,
                              TagEntityMapper tagEntityMapper,
                              CategoryEntityMapper categoryEntityMapper,
                              ActorCommandAction actorCommandAction,
                              CreatorCommandAction creatorCommandAction,
                              TagCommandAction tagCommandAction,
                              CategoryCommandAction categoryCommandAction,
                              VideoCommandAction videoCommandAction,
                              ActorQueryAction actorQueryAction,
                              CreatorQueryAction creatorQueryAction,
                              TagQueryAction tagQueryAction,
                              CategoryQueryAction categoryQueryAction,
                              VideoQueryAction videoQueryAction) {
        this.repository = repository;
        this.actorEntityMapper = actorEntityMapper;
        this.creatorEntityMapper = creatorEntityMapper;
        this.movieEntityMapper = movieEntityMapper;
        this.videoEntityMapper = videoEntityMapper;
        this.tagEntityMapper = tagEntityMapper;
        this.categoryEntityMapper = categoryEntityMapper;
        this.actorCommandAction = actorCommandAction;
        this.creatorCommandAction = creatorCommandAction;
        this.tagCommandAction = tagCommandAction;
        this.categoryCommandAction = categoryCommandAction;
        this.videoCommandAction = videoCommandAction;
        this.actorQueryAction = actorQueryAction;
        this.creatorQueryAction = creatorQueryAction;
        this.tagQueryAction = tagQueryAction;
        this.categoryQueryAction = categoryQueryAction;
        this.videoQueryAction = videoQueryAction;
    }



    @Transactional
    public MovieEntity addMovie(@Valid AddMovieReq newMovie) {
        MovieEntity newMovieEntity = movieEntityMapper.toEntity(newMovie);
        newMovieEntity.setActors(newMovie.getActors().stream()
                .map(actor -> {
                    Optional<ActorEntity> actorOptional;
                    ActorEntity getActor;
                    ActorEntity actorEntities = actorEntityMapper.toActorEntity(actor);

                    actorOptional = actorQueryAction.findActor(actorEntities.getId());
                    if (actorOptional.isEmpty()) {
                        throw new ResourceNotFoundException("actor with id" + actor.getId() + " not found");
                    }

                    return actorEntities;
                })
                .collect(Collectors.toSet()));

        newMovieEntity.setCreators(newMovie.getCreators().stream()
                .map(creator -> {
                    Optional<CreatorEntity> creatorOptional;
                    CreatorEntity getCreator;
                    CreatorEntity creatorEntities = creatorEntityMapper.creatorDtotoCreatorEntity(creator);
                    creatorOptional = creatorQueryAction.findById(creatorEntities.getId());
                    if (creatorOptional.isEmpty()) {
                        throw new ResourceNotFoundException("director with id" + creator.getId() + " not found");
                    }

                    return creatorEntities;
                }).collect(Collectors.toSet()));




        newMovieEntity.setCategories(newMovie.getCategories().stream()
                .map(category -> {
                    Optional<CategoryEntity> categoryOptional;
                    CategoryEntity getCategory;
                    CategoryEntity categoryEntity = categoryEntityMapper.toEntity(category);
                    categoryOptional = categoryQueryAction.findById(categoryEntity.getId());
                    if (categoryOptional.isEmpty()) {
                        throw new ResourceNotFoundException("category with id" + category.getId() + " not found");
                    }

                    return categoryEntity;
                }).collect(Collectors.toSet()));


        Set<VideoEntity> videoToUpdated = new HashSet<>();

//        if (newMovie.getVideos() != null) {
//            videoToUpdated = newMovie.getVideos().stream().map(
//                    video -> {
//                        VideoEntity getVideo;
//                        Optional<VideoEntity> optionalVid;
//                        VideoEntity videoEntity = videoEntityMapper.videoDtoToEntity(video, newMovieEntity);
//                        optionalVid = videoQueryAction.findById(videoEntity.getId());
//                        if (!optionalVid.isPresent()) {
//                            throw new ResourceNotFoundException("video with id " + video.getId() + " is not found!");
//                        }
//
//                        videoEntity.setMovie(newMovieEntity);
//
//                        return videoEntity;
//                    }
//            ).collect(Collectors.toSet());
//            newMovieEntity.setVideos(
//                    videoToUpdated
//            );
//        }
//

        MovieEntity savedMovie = repository.save(newMovieEntity);

//        videoCommandAction.updateEntityBatch(videoToUpdated);

        return savedMovie;
    }


    @Transactional
    public MovieEntity updateMovie(@NotNull @Valid int movieId,
                                   @NotNull @Valid AddMovieReq newMovie) {

        Optional<MovieEntity> movie = repository.findById(movieId);
        if (!movie.isPresent()) {
            throw new ResourceNotFoundException("movie with id: " + movie.get().getId() + " not found");
        }
        MovieEntity updatedMovie = movie.get();
        Timestamp modelTimestamp = Timestamp.valueOf(newMovie.getrYear().atStartOfDay());

        updatedMovie.setId(movieId).setName(newMovie.getName()).setrYear(modelTimestamp)
                .setIdmbRating(newMovie.getIdmbRating()).setMpaRating(newMovie.getMpaRating())
                .setSynopsis(newMovie.getSynopsis()).setType(newMovie.getType())
        ;
        updatedMovie.setActors(newMovie.getActors().stream()
                .map(actor -> {
                    Optional<ActorEntity> actorOptional;
                    ActorEntity getActor;
                    ActorEntity actorEntities = actorEntityMapper.toActorEntity(actor);
                    actorOptional = actorQueryAction.findActor(actor.getId());
                    if (!actorOptional.isPresent()) {
                        throw new ResourceNotFoundException("actor with id" + actor.getId() + " not found");

                    }


                    return actorEntities;
                })
                .collect(Collectors.toSet()));

        updatedMovie.setCreators(newMovie.getCreators().stream()
                .map(creator -> {
                    Optional<CreatorEntity> creatorOptional;
                    CreatorEntity getCreator;
                    CreatorEntity creatorEntities = creatorEntityMapper.creatorDtotoCreatorEntity(creator);
                    creatorOptional = creatorQueryAction.findById(creatorEntities.getId());
                    if (!creatorOptional.isPresent()) {
                        throw new ResourceNotFoundException("director with id" + creator.getId() + " not found");
                    }


                    return creatorEntities;
                }).collect(Collectors.toSet()));



        updatedMovie.setCategories(newMovie.getCategories().stream()
                .map(category -> {
                    Optional<CategoryEntity> categoryOptional;
                    CategoryEntity getCategory;
                    CategoryEntity categoryEntity = categoryEntityMapper.toEntity(category);
                    categoryOptional = categoryQueryAction.findById(categoryEntity.getId());
                    if (!categoryOptional.isPresent()) {

                        throw new ResourceNotFoundException("category with id" + category.getId() + " not found");

                    }

                    return categoryEntity;
                }).collect(Collectors.toSet()));

        Set<VideoEntity> oldVideoInMovieToDelete = updatedMovie.getVideos();
        Set<VideoEntity> newVideoInMovie = new HashSet<>();

//        if (newMovie.getVideos() != null) {
//
//            updatedMovie.setVideos(
//                    newMovie.getVideos().stream().map(
//                            video -> {
//                                VideoEntity getVideo;
//                                Optional<VideoEntity> optionalVid;
//                                VideoEntity videoEntity = videoEntityMapper.videoDtoToEntity(video, updatedMovie);
//                                optionalVid = videoQueryAction.findById(videoEntity.getId());
//                                if (!optionalVid.isPresent()) {
//                                    throw new ResourceNotFoundException("video with id " + video.getId() + " is not found!");
//
//                                }
//
//                                //                        delete video if not in request
//                                if (oldVideoInMovieToDelete.contains(videoEntity)){
////                            video already in movie
//                                    oldVideoInMovieToDelete.remove(videoEntity);
//                                } else {
////                            video not in movie
//                                    videoEntity.setMovie(updatedMovie);
//                                    newVideoInMovie.add(videoEntity);
//
//                                }
//
//                                return videoEntity;
//                            }
//                    ).collect(Collectors.toSet())
//            );
//            oldVideoInMovieToDelete.forEach(video ->{
//                video.removeMovie();
//                videoCommandAction.delteVideoEntity(video);
//            } );
//
//        } else{
//            updatedMovie.setVideos(Set.of());
//        }

        updatedMovie.setId(movieId);

        MovieEntity savedUpdatedMovie = saveMovie(updatedMovie);
//        videoCommandAction.updateEntityBatch(newVideoInMovie);

        return savedUpdatedMovie;
    }

    @Transactional
    public MovieEntity saveMovie(MovieEntity movie) {
        return repository.save(movie);
    }


    public MovieEntity getMovieById(@NotNull @Valid int movieId) {
        Optional<MovieEntity> entity = repository.findById(movieId);
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException("movie with id: " + entity.get().getId() + " not found");
        }
        MovieEntity movie = entity.get();
        return movie;
    }


    public String deleteMovie(@NotNull @Valid int movieId) {
        Optional<MovieEntity> movie = repository.findById(movieId);
        if (!movie.isPresent()) {
            throw new ResourceNotFoundException("movie with id: " + movie.get().getId() + " not found");
        }
        MovieEntity movieEntity = movie.get();
        Set<ActorEntity> emptyActor = new HashSet<>();
        Set<CreatorEntity> emptyCreator = new HashSet<>();
        Set<TagEntity> emptyTag = new HashSet<>();
        Set<CategoryEntity> emptyCategory = new HashSet<>();
        movieEntity.setActors(emptyActor);
        movieEntity.setCreators(emptyCreator);
        movieEntity.setTags(emptyTag);
        movieEntity.setCategories(emptyCategory);
        movieEntity.getActors().stream().map(actor -> {

            actor.removeMovie(movieEntity);
            return actor;
        });
        movieEntity.getCreators().stream().map(creator -> {

            creator.removeMovie(movieEntity);
            return creator;
        });

        if (!movieEntity.getTags().isEmpty()){
            movieEntity.getTags().stream().map(tag -> {
                tag.removeMovie(movieEntity);
                return tag;
            });
        }

        movieEntity.getCategories().stream().map(category -> {
            category.removeMovie(movieEntity);
            return category;
        });

        videoCommandAction.deleteVideoByMovie(movieEntity.getId() );


        MovieEntity deletedMovie = repository.save(movieEntity);
        repository.deleteById(movieId);

        String res = "movie deleted!";
        return res;
    }

}
