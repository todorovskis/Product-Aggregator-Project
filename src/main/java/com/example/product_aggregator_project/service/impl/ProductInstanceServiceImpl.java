package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.ProductInstance;
import com.example.product_aggregator_project.repository.ProductInstanceRepository;
import com.example.product_aggregator_project.service.ProductInstanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInstanceServiceImpl implements ProductInstanceService {

    private final ProductInstanceRepository productInstanceRepository;

    public ProductInstanceServiceImpl(ProductInstanceRepository productInstanceRepository) {
        this.productInstanceRepository = productInstanceRepository;
    }

    @Override
    public List<ProductInstance> listProductInstances() {
        return this.productInstanceRepository.findAll();
    }
}
