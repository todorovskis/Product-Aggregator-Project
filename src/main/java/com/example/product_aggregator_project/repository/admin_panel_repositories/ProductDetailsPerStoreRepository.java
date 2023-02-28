package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.dto.ProductDetailsPerStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsPerStoreRepository extends JpaRepository<ProductDetailsPerStore, Integer> {

    @Query(value = "select * from project.product_details_per_store", nativeQuery = true)
    List<ProductDetailsPerStore> findProductDetailsPerStore();
}
