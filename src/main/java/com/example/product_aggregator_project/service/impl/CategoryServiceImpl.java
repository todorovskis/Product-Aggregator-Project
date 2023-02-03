package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.repository.CategoryRepository;
import com.example.product_aggregator_project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();
    }
}
