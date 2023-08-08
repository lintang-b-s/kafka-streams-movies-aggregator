package com.kafkastreams.movieservice.command.action;


import com.kafkastreams.movieservice.api.request.AddActorReq;
import com.kafkastreams.movieservice.entity.ActorEntity;
import com.kafkastreams.movieservice.exception.ResourceNotFoundException;
import com.kafkastreams.movieservice.repository.ActorRepository;
import com.kafkastreams.movieservice.util.entityMapper.ActorEntityMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ActorCommandAction {
    private ActorRepository repository;
    private ActorEntityMapper mapper;

    public ActorEntity addActor( AddActorReq newActor) {
        ActorEntity actor =  repository.save(mapper.toEntity(newActor));
        return actor;
    }

    public Optional<ActorEntity> getByActorId( int id) {
        Optional<ActorEntity> actor = repository.findById(id);

        return actor;
    }

    public Optional<ActorEntity> updateActor(int actorId, AddActorReq newActor) {
        Optional<ActorEntity> actor = repository.findById(actorId);
        if (!actor.isPresent()) {
          throw  new ResourceNotFoundException("actor with id: " + actorId + " not found");
        }
        ActorEntity updatedActor = actor.get();
        updatedActor.setName(newActor.getName());
        return Optional.of(repository.save(updatedActor));
    }

}