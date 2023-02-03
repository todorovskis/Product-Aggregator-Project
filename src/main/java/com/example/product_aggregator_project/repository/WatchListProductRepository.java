package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.WatchListProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListProductRepository extends JpaRepository<WatchListProduct, Integer> {
}
