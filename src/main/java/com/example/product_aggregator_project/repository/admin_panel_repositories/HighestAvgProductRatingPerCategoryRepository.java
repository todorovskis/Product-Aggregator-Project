package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.HighestAvgProductRatingPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighestAvgProductRatingPerCategoryRepository extends JpaRepository<HighestAvgProductRatingPerCategory, Integer> {

    @Query(value = "select * from project.highest_avg_product_rating_per_category", nativeQuery = true)
    List<HighestAvgProductRatingPerCategory> findHighestAvgProductRatingPerCategory();
}
