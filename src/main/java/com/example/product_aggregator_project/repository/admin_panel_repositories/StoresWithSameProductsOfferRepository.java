package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.dto.StoresWithSameProductsOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresWithSameProductsOfferRepository extends JpaRepository<StoresWithSameProductsOffer, Integer> {

    @Query(value = "select * from project.same_product_offer", nativeQuery = true)
    List<StoresWithSameProductsOffer> findStoresWithSameProductsOffer();
}
