package com.kafkastreams.movieservice.command.action;

import com.kafkastreams.movieservice.api.request.AddCategoryReq;
import com.kafkastreams.movieservice.entity.CategoryEntity;
import com.kafkastreams.movieservice.exception.ResourceNotFoundException;
import com.kafkastreams.movieservice.repository.CategoryRepository;
import com.kafkastreams.movieservice.util.entityMapper.CategoryEntityMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class CategoryCommandAction {

    private CategoryRepository categoryRepository;
    private CategoryEntityMapper categoryEntityMapper;

    public CategoryEntity save(AddCategoryReq newCategory) {
        CategoryEntity category= categoryRepository.save(categoryEntityMapper.toEntity(newCategory.getName()));
        return category;
    }


    public CategoryEntity update(int categoryId,AddCategoryReq newCategory) {

        Optional<CategoryEntity > category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("category with id: " + categoryId + " not found " );
        }
        CategoryEntity categoryEntity = category.get();
        categoryEntity.setName(newCategory.getName());
        CategoryEntity updateCategory= categoryRepository.save(categoryEntity);
        return updateCategory;
    }

    public CategoryEntity findById(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
