package com.kafkastreams.movieservice.repository;

import com.kafkastreams.movieservice.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
    Optional<ActorEntity> findById(int actorId);

}
