package com.globalmemories.backend.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalmemories.backend.repositories.CategoryRepository;
import com.globalmemories.backend.dtos.CategoryDto;
import com.globalmemories.backend.entites.Category;
import com.globalmemories.backend.mappers.CategoryMapper;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + categoryId));
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> countries = categoryRepository.findAll();
        return categoryMapper.toDtoList(countries);
    }
}