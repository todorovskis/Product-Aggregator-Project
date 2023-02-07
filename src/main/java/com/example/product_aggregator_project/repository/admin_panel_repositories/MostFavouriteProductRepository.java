package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.MostFavouriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MostFavouriteProductRepository extends JpaRepository<MostFavouriteProduct, Integer> {

    @Query(value = "select * from project.most_favourite_product", nativeQuery = true)
    List<MostFavouriteProduct> findMostFavouriteProducts();
}
