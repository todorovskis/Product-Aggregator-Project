package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.admin_panel.MostFavouriteProduct;
import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerManufacturer;
import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerStore;
import com.example.product_aggregator_project.model.admin_panel.ProductNumberPerCategory;

import java.util.List;

public interface AdminPanelService {

    List<ProductNumberPerCategory> findNumProductsPerCategory();

    List<ProductDetailsPerManufacturer> findProductDetailsPerManufacturer();

    List<ProductDetailsPerStore> findProductDetailsPerStore();

    List<MostFavouriteProduct> findMostFavouriteProducts();
}
