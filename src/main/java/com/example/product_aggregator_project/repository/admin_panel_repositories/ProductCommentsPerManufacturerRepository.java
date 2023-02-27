package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.ProductCommentsPerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsPerManufacturerRepository extends JpaRepository<ProductCommentsPerManufacturer, Integer> {

//    @Query(value = "select * from project.product_comments_per_manufacturer", nativeQuery = true)
//    List<ProductCommentsPerManufacturer> findProductCommentsPerManufacturer();
}
