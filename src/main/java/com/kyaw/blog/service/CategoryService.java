package com.kyaw.blog.service;

import com.kyaw.blog.domain.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category createCategory(Category createdCategory);
}
