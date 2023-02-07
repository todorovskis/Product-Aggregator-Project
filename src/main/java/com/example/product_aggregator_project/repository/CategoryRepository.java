package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByCategoryNameContainingIgnoreCase(String input);

    List<Category> findAllByParentCategoryIsNotNull();
}

