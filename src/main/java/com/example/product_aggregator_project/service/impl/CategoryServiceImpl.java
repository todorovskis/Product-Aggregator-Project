package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.exceptions.CategoryIdNotFoundException;
import com.example.product_aggregator_project.repository.CategoryRepository;
import com.example.product_aggregator_project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Category findById(Integer categoryId) {
        return this.categoryRepository.findById(categoryId)
                .orElseThrow(CategoryIdNotFoundException::new);
    }

    @Override
    public List<Category> listCategoriesByInput(String input) {
        return this.categoryRepository.findByCategoryNameContainingIgnoreCase(input);
    }

    @Override
    public List<Product> listProductsByCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(CategoryIdNotFoundException::new);

        List<Product> products = new ArrayList<>();
        addProducts(category, products);

        return products.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Category findCategoryInProductCategories(Product product) {
      for(Category c1: this.categoryRepository.findAll()){
          for(Category c2: product.getCategories()){
              if(c1.getId().equals(c2.getId()))
                  return c1;
          }
      }
      return null;
    }

    private void addProducts(Category category, List<Product> products) {
        products.addAll(category.getProducts());
        category.getSubcategories().forEach(s -> addProducts(s, products));
    }
}
