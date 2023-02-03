package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProducts() {
        return this.productRepository.findAll();
    }
}
