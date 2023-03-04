package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.UserFavourite;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    List<Product> listProducts();

    Product findById(Integer productId);

    Product addProduct(String productName, Integer categoryId, Integer manufacturerId,
                       LocalDate postDate, String characteristic);

    List<Product> listProductsByNameAndCategoryAndManufacturer(String name, Integer categoryId, Integer manufacturerId);
}
