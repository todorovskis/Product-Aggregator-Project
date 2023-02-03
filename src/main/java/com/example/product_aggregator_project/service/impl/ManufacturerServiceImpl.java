package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.repository.ManufacturerRepository;
import com.example.product_aggregator_project.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> listManufacturers() {
        return this.manufacturerRepository.findAll();
    }
}
