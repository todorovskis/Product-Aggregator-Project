package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsPerManufacturerRepository extends JpaRepository<ProductDetailsPerManufacturer, Integer> {

    @Query(value = "select * from project.product_details_per_manufacturer", nativeQuery = true)
    List<ProductDetailsPerManufacturer> findProductDetailsPerManufacturer();
}
