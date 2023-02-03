package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.ProductImage;
import com.example.product_aggregator_project.repository.ProductImageRepository;
import com.example.product_aggregator_project.service.ProductImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public List<ProductImage> listProductImages() {
        return this.productImageRepository.findAll();
    }
}
