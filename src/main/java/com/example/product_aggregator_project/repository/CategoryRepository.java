package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    //Optional<Category> findById(Long categoryId);

    List<Category> findByCategoryNameContainingIgnoreCase(String input);
}

