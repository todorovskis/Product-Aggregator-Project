package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> listManufacturers();

    List<Manufacturer> listManufacturersByInput(String input);

    List<Product> listProductsByManufacturer(Integer manufacturerId);
}
