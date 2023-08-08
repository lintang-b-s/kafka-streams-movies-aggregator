package com.kafkastreams.movieservice.repository;

import com.kafkastreams.movieservice.entity.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreatorRepository  extends JpaRepository<CreatorEntity, Integer> {

    Optional<CreatorEntity> findById(int creatorId);
}
