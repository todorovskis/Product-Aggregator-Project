package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.admin_panel.*;

import com.example.product_aggregator_project.repository.admin_panel_repositories.*;
import com.example.product_aggregator_project.service.AdminPanelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {

    private final StoresWithAllManufacturerProductsRepository storesWithAllManufacturerProductsRepository;
    private final StoresWithSameProductsOfferRepository storesWithSameProductsOfferRepository;
    private final HighestAvgProductRatingPerCategoryRepository highestAvgProductRatingPerCategoryRepository;
    private final ProductCommentsPerManufacturerRepository productCommentsPerManufacturerRepository;
    private final FavouriteProductPerCategoryRepository favouriteProductPerCategoryRepository;
    private final MostFavouriteProductRepository mostFavouriteProductRepository;
    private final ProductDetailsPerStoreRepository productDetailsPerStoreRepository;
    private final ProductDetailsPerManufacturerRepository productDetailsPerManufacturerRepository;
    private final ProductNumberPerCategoryRepository productNumberPerCategoryRepository;

    public AdminPanelServiceImpl(
            StoresWithAllManufacturerProductsRepository storesWithAllManufacturerProductsRepository,
            StoresWithSameProductsOfferRepository storesWithSameProductsOfferRepository,
            HighestAvgProductRatingPerCategoryRepository highestAvgProductRatingPerCategoryRepository,
            ProductCommentsPerManufacturerRepository productCommentsPerManufacturerRepository,
            FavouriteProductPerCategoryRepository favouriteProductPerCategoryRepository,
            MostFavouriteProductRepository mostFavouriteProductRepository,
            ProductDetailsPerStoreRepository productDetailsPerStoreRepository,
            ProductDetailsPerManufacturerRepository productDetailsPerManufacturerRepository,
            ProductNumberPerCategoryRepository productNumberPerCategoryRepository) {
        this.storesWithAllManufacturerProductsRepository = storesWithAllManufacturerProductsRepository;
        this.storesWithSameProductsOfferRepository = storesWithSameProductsOfferRepository;
        this.highestAvgProductRatingPerCategoryRepository = highestAvgProductRatingPerCategoryRepository;
        this.productCommentsPerManufacturerRepository = productCommentsPerManufacturerRepository;
        this.favouriteProductPerCategoryRepository = favouriteProductPerCategoryRepository;
        this.mostFavouriteProductRepository = mostFavouriteProductRepository;
        this.productDetailsPerStoreRepository = productDetailsPerStoreRepository;
        this.productDetailsPerManufacturerRepository = productDetailsPerManufacturerRepository;

        this.productNumberPerCategoryRepository = productNumberPerCategoryRepository;
    }

    @Override
    public List<ProductNumberPerCategory> findNumProductsPerCategory() {
        return this.productNumberPerCategoryRepository.findNumProductsPerCategory();
    }

    @Override
    public List<ProductDetailsPerManufacturer> findProductDetailsPerManufacturer() {
        return this.productDetailsPerManufacturerRepository.findProductDetailsPerManufacturer();
    }

    @Override
    public List<ProductDetailsPerStore> findProductDetailsPerStore() {
        return this.productDetailsPerStoreRepository.findProductDetailsPerStore();
    }

    @Override
    public List<MostFavouriteProduct> findMostFavouriteProducts() {
        return this.mostFavouriteProductRepository.findMostFavouriteProducts();
    }

    @Override
    public List<FavouriteProductPerCategory> findFavouriteProductsPerCategory() {
        return this.favouriteProductPerCategoryRepository.findFavouriteProductsPerCategory();
    }

    @Override
    public List<ProductCommentsPerManufacturer> findProductCommentsPerManufacturer() {
        return this.productCommentsPerManufacturerRepository.findProductCommentsPerManufacturer();
    }

    @Override
    public List<HighestAvgProductRatingPerCategory> findHighestAvgProductRatingPerCategory() {
        return this.highestAvgProductRatingPerCategoryRepository.findHighestAvgProductRatingPerCategory();
    }

    @Override
    public List<StoresWithSameProductsOffer> findStoresWithSameProductsOffer() {
        return this.storesWithSameProductsOfferRepository.findStoresWithSameProductsOffer();
    }

    @Override
    public List<StoresWithAllManufacturerProducts> findStoresWithAllManufacturerProducts() {
        return this.storesWithAllManufacturerProductsRepository.findStoresWithAllManufacturerProducts();
    }
}
