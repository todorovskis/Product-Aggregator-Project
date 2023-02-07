package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.FavouriteProductPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteProductPerCategoryRepository extends JpaRepository<FavouriteProductPerCategory, Integer> {

    @Query(value = "select * from project.favourite_product_per_category", nativeQuery = true)
    List<FavouriteProductPerCategory> findFavouriteProductsPerCategory();
}
