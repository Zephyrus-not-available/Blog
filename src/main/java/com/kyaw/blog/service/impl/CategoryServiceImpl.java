package com.kyaw.blog.service.impl;

import com.kyaw.blog.domain.entity.Category;
import com.kyaw.blog.repository.CategoryRepository;
import com.kyaw.blog.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category createdCategory) {
        if(categoryRepository.existsByNameIgnoreCase(createdCategory.getName())){
            throw new IllegalArgumentException("Category with name '" + createdCategory.getName() + "' already exists.");
        }
        return categoryRepository.save(createdCategory);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            if (categoryOptional.isEmpty()) {
                throw new IllegalArgumentException("Category with id '" + id + "' not found.");
            }
            categoryRepository.deleteById(id);
        }
    }


}
