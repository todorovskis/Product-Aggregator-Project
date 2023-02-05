package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.exceptions.CategoryIdNotFoundException;
import com.example.product_aggregator_project.repository.CategoryRepository;

import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> listProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> findProductsByNameAndCategory(String name, Integer categoryId) {
        Category category = categoryId != null ? this.categoryRepository.findById(categoryId)
                .orElse(null) : null;
        if(name != null && category != null){
            return this.productRepository.findAllByProductNameEqualsAndCategoriesContaining(name, category);
        }
        else if(name != null){
            return this.productRepository.findAllByProductNameEquals(name);
        }
        else if(category != null){
            return this.productRepository.findAllByCategoriesContaining(category);
        }
        else{
            return this.productRepository.findAll();
        }
    }
}
