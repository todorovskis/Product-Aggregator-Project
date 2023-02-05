package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProducts();

    List<Product> findProductsByNameAndCategory(String name, Integer categoryId);

    //TODO: FILTERING OF PRODUCTS

}
