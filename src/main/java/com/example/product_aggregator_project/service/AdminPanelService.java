package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.admin_panel.dto.*;

import java.util.List;

public interface AdminPanelService {

    List<ProductNumberPerCategory> findNumProductsPerCategory();

    List<ProductDetailsPerManufacturer> findProductDetailsPerManufacturer();

    List<ProductDetailsPerStore> findProductDetailsPerStore();

    List<MostFavouriteProduct> findMostFavouriteProducts();

    List<FavouriteProductPerCategory> findFavouriteProductsPerCategory();

    List<ProductCommentsPerManufacturer> findProductCommentsPerManufacturer();

    List<HighestAvgProductRatingPerCategory> findHighestAvgProductRatingPerCategory();

    List<StoresWithSameProductsOffer> findStoresWithSameProductsOffer();

    List<StoresWithAllManufacturerProducts> findStoresWithAllManufacturerProducts();
}
