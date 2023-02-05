package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.admin_panel.MostFavouriteProduct;
import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerManufacturer;

import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerStore;
import com.example.product_aggregator_project.model.admin_panel.ProductNumberPerCategory;
import com.example.product_aggregator_project.repository.admin_panel_repositories.AdminPanelRepositoryQuery6;
import com.example.product_aggregator_project.repository.admin_panel_repositories.AdminPanelRepositoryQuery7;
import com.example.product_aggregator_project.repository.admin_panel_repositories.AdminPanelRepositoryQuery8;
import com.example.product_aggregator_project.repository.admin_panel_repositories.AdminPanelRepositoryQuery9;
import com.example.product_aggregator_project.service.AdminPanelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {

    private final AdminPanelRepositoryQuery6 adminPanelRepositoryQuery6;
    private final AdminPanelRepositoryQuery7 adminPanelRepositoryQuery7;
    private final AdminPanelRepositoryQuery8 adminPanelRepositoryQuery8;
    private final AdminPanelRepositoryQuery9 adminPanelRepositoryQuery9;

    public AdminPanelServiceImpl(
            AdminPanelRepositoryQuery6 adminPanelRepositoryQuery6,
            AdminPanelRepositoryQuery7 adminPanelRepositoryQuery7,
            AdminPanelRepositoryQuery8 adminPanelRepositoryQuery8,
            AdminPanelRepositoryQuery9 adminPanelRepositoryQuery9) {
        this.adminPanelRepositoryQuery6 = adminPanelRepositoryQuery6;
        this.adminPanelRepositoryQuery7 = adminPanelRepositoryQuery7;
        this.adminPanelRepositoryQuery8 = adminPanelRepositoryQuery8;

        this.adminPanelRepositoryQuery9 = adminPanelRepositoryQuery9;
    }

    @Override
    public List<ProductNumberPerCategory> findNumProductsPerCategory() {
        return this.adminPanelRepositoryQuery9.findNumProductsPerCategory();
    }

    @Override
    public List<ProductDetailsPerManufacturer> findProductDetailsPerManufacturer() {
        return this.adminPanelRepositoryQuery8.findProductDetailsPerManufacturer();
    }

    @Override
    public List<ProductDetailsPerStore> findProductDetailsPerStore() {
        return this.adminPanelRepositoryQuery7.findProductDetailsPerStore();
    }

    @Override
    public List<MostFavouriteProduct> findMostFavouriteProducts() {
        return this.adminPanelRepositoryQuery6.findMostFavouriteProducts();
    }
}
