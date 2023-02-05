package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProducts();

    Product findById(Integer productId);

    List<Product> listProductsByNameAndCategoryAndManufacturer(String name, Integer categoryId, Integer manufacturerId);

    //TODO: FILTERING OF PRODUCTS

}
