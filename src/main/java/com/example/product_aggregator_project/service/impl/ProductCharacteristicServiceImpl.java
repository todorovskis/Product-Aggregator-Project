package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.ProductCharacteristic;
import com.example.product_aggregator_project.repository.ProductCharacteristicRepository;
import com.example.product_aggregator_project.service.ProductCharacteristicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCharacteristicServiceImpl implements ProductCharacteristicService {

    private final ProductCharacteristicRepository productCharacteristicRepository;

    public ProductCharacteristicServiceImpl(ProductCharacteristicRepository productCharacteristicRepository) {
        this.productCharacteristicRepository = productCharacteristicRepository;
    }

    @Override
    public List<ProductCharacteristic> listProductCharacteristics() {
        return this.productCharacteristicRepository.findAll();
    }
}
