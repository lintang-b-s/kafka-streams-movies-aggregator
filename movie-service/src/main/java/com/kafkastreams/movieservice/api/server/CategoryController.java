package com.kafkastreams.movieservice.api.server;

import com.kafkastreams.movieservice.api.request.AddCategoryReq;
import com.kafkastreams.movieservice.command.service.CategoryCommandService;
import com.kafkastreams.movieservice.util.entityMapper.CategoryEntityMapper;
import com.kafkastreams.movieservice.api.response.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/movie-service/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryEntityMapper categoryEntityMapper;

    @Autowired
    private CategoryCommandService categoryCommandService;

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody AddCategoryReq newCategory) {
        return ok(categoryEntityMapper.toDto(categoryCommandService.addCategory(newCategory)));
    }

    @PutMapping("/{categoryid}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable(value = "categoryid") int tagId, @RequestBody AddCategoryReq updateCategory) {
        return ok(categoryEntityMapper.toDto(categoryCommandService.updateCategory(tagId, updateCategory)));
    }
}
