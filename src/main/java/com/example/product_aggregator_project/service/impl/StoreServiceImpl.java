package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Store;
import com.example.product_aggregator_project.repository.StoreRepository;
import com.example.product_aggregator_project.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> listStores() {
        return this.storeRepository.findAll();
    }
}
