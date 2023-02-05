package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Product;

import java.util.List;

public interface CategoryService {

    List<Category> listCategories();
    List<Category> listCategoriesByInput(String input);
    List<Product> listProductsByCategory(Integer categoryId);
}
