package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.Category;

import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductNameContainingIgnoreCase(String productName);

    List<Product> findAllByCategoriesContaining(Category category);

    List<Product> findAllByManufacturerEquals(Manufacturer manufacturer);

    List<Product> findAllByProductNameContainingIgnoreCaseAndCategoriesContaining(String productName, Category category);

    List<Product> findAllByProductNameContainingIgnoreCaseAndManufacturerEquals(String productName, Manufacturer manufacturer);

    List<Product> findAllByCategoriesContainingAndManufacturerEquals(Category category, Manufacturer manufacturer);

    List<Product> findAllByProductNameContainingIgnoreCaseAndCategoriesContainingAndManufacturerEquals(String name, Category category, Manufacturer manufacturer);
}
