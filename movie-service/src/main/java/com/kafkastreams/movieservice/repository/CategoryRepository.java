package com.kafkastreams.movieservice.repository;

import com.kafkastreams.movieservice.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findById(int categoryId);

}
