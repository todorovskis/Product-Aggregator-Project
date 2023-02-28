package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.dto.ProductNumberPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductNumberPerCategoryRepository extends JpaRepository<ProductNumberPerCategory, Integer> {

    @Query(value = "select * from project.num_products_by_category", nativeQuery = true)
    List<ProductNumberPerCategory> findNumProductsPerCategory();

}
