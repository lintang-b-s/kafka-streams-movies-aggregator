package com.lintang.netflik.movieservice.util.messageMapper;


import com.lintang.netflik.movieservice.broker.message.AddMovieMessage;
import com.lintang.netflik.movieservice.entity.MovieEntity;
import com.lintang.netflik.movieservice.util.DtoMapper.ActorDtoMapper;
import com.lintang.netflik.movieservice.util.DtoMapper.CreatorDtoMapper;
import com.lintang.netflik.movieservice.util.DtoMapper.VideoDtoMapper;
import com.lintang.netflik.movieservice.util.entityMapper.ActorEntityMapper;
import com.lintang.netflik.movieservice.util.entityMapper.CategoryEntityMapper;
import com.lintang.netflik.movieservice.util.entityMapper.TagEntityMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class MovieMessageMapper {


    private ActorDtoMapper actorDtoMapper;
    private CreatorDtoMapper creatorDtoMapper;
    private VideoDtoMapper videoDtoMapper;
    private TagEntityMapper tagEntityMapper;
    private CategoryEntityMapper categoryEntityMapper;

    public AddMovieMessage movieEntityToMessage(MovieEntity m) {
        AddMovieMessage message = AddMovieMessage.builder()
                .id(m.getId()).name(m.getName()).type(m.getType())
                .synopsis(m.getSynopsis()).mpaRating(m.getMpaRating())
                .rYear(m.getrYear().toLocalDateTime()).idmbRating(m.getIdmbRating())
                .actors(
                        m.getActors().stream().map(
                                actor -> {return actorDtoMapper.actorEntityToActorDto( actor);}
                        ).collect(Collectors.toSet()))
                .creators(
                        m.getCreators().stream().map(
                                creator -> {return creatorDtoMapper.creatorEntityToCreatorDto(creator);}
                        ).collect(Collectors.toSet()))
                .videos(
                        m.getVideos().stream().map(
                                video -> {return videoDtoMapper.videoEntityToVideoDto(video);}
                        ).collect(Collectors.toSet()))
                .image(m.getImage())
                .tags(
                        m.getTags().stream().map(
                                tag -> {return tagEntityMapper.toDto(tag);}
                        ).collect(Collectors.toSet()))
                .categories(
                        m.getCategories().stream().map(
                                category ->{ return categoryEntityMapper.toDto(category);}
                        ).collect(Collectors.toSet()))
                .build();
        return message;
    }




}
