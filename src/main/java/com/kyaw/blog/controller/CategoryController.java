package com.kyaw.blog.controller;

import com.kyaw.blog.domain.dto.CategoryDto;
import com.kyaw.blog.domain.entity.Category;
import com.kyaw.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return categories;
    }
}
