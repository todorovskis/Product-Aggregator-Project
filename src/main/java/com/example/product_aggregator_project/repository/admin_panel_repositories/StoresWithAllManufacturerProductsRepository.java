package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.StoresWithAllManufacturerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresWithAllManufacturerProductsRepository extends JpaRepository<StoresWithAllManufacturerProducts, Integer> {

//    @Query(value = "select * from project.all_manufacturer_products", nativeQuery = true)
//    List<StoresWithAllManufacturerProducts> findStoresWithAllManufacturerProducts();
}
