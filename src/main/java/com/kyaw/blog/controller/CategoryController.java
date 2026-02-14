package com.kyaw.blog.controller;

import com.kyaw.blog.domain.dto.CategoryDto;
import com.kyaw.blog.domain.entity.Category;
import com.kyaw.blog.mapper.CategoryMapper;
import com.kyaw.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categoryDtos = categoryService.getCategories().stream()
                .map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categoryDtos);

    }
}
