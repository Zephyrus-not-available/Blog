package com.kyaw.blog.service;

import com.kyaw.blog.domain.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getCategories();

    Category createCategory(Category createdCategory);

    void deleteCategory(UUID id);
}
