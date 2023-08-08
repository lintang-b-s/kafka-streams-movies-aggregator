package com.kafkastreams.movieservice.command.action;


import com.kafkastreams.movieservice.api.request.AddCreatorReq;
import com.kafkastreams.movieservice.entity.CreatorEntity;
import com.kafkastreams.movieservice.exception.ResourceNotFoundException;
import com.kafkastreams.movieservice.repository.CreatorRepository;
import com.kafkastreams.movieservice.util.entityMapper.CreatorEntityMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CreatorCommandAction {

    private CreatorRepository repository;
    private CreatorEntityMapper mapper;


    public CreatorEntity addCreator(AddCreatorReq newCreator) {
       CreatorEntity cre =  repository.save(mapper.toEntity(newCreator));
        return cre;
    }

    public CreatorEntity getCreatorById(int creatorId) {
        Optional<CreatorEntity> creator = repository.findById(creatorId);

        return creator.get();
    }

    public Optional<CreatorEntity> updateCreator(int creatorId , AddCreatorReq newCreator) {
        Optional<CreatorEntity> creator = repository.findById(creatorId);
        if (!creator.isPresent()) {
           throw new  ResourceNotFoundException("creator with id : " + creatorId +  " not found" );
        }
        CreatorEntity updatedCreator = creator.get();
        updatedCreator.setName(newCreator.getName());
        return Optional.of(repository.save(updatedCreator));
    }
}
