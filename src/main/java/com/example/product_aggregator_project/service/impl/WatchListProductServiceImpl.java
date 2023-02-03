package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.WatchListProduct;
import com.example.product_aggregator_project.repository.WatchListProductRepository;
import com.example.product_aggregator_project.service.WatchListProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchListProductServiceImpl implements WatchListProductService {

    private WatchListProductRepository watchListProductRepository;

    public WatchListProductServiceImpl(WatchListProductRepository watchListProductRepository) {
        this.watchListProductRepository = watchListProductRepository;
    }

    @Override
    public List<WatchListProduct> listWatchListProducts() {
        return this.watchListProductRepository.findAll();
    }
}
