package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.repository.ManufacturerRepository;
import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Manufacturer> listManufacturers() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public List<Manufacturer> listManufacturersByInput(String input) {
        return this.manufacturerRepository.findByManufacturerNameContainingIgnoreCase(input);
    }

    @Override
    public List<Product> listProductsByManufacturer(Integer manufacturerId) {
        Manufacturer manufacturer = manufacturerId != null ? this.manufacturerRepository.findById(manufacturerId)
                .orElse(null) : null;

        if(manufacturer != null){
            return this.productRepository.findAllByManufacturerEquals(manufacturer);
        }
        else{
            return this.productRepository.findAll();
        }
    }
}
