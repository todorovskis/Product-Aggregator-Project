package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.FavouriteProductPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteProductPerCategoryRepository extends JpaRepository<FavouriteProductPerCategory, Integer> {

}
