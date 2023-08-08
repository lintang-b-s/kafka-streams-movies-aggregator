package com.kafkastreams.movieservice.repository;

import com.kafkastreams.movieservice.entity.OutboxEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutboxRepository extends CrudRepository<OutboxEntity, Long> {
}
