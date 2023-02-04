package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.Category;

import com.example.product_aggregator_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByProductNameEquals(String productName);

    List<Product> findAllByCategoriesContaining(Category category);

    List<Product> findAllByProductNameEqualsAndCategoriesContaining(String name, Category category);
}
