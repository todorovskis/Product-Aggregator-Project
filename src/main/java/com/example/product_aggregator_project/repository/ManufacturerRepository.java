package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
