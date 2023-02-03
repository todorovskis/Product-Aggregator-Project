package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.UserFavourite;
import com.example.product_aggregator_project.repository.UserFavouriteRepository;
import com.example.product_aggregator_project.service.UserFavouriteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavouriteServiceImpl implements UserFavouriteService {

    private UserFavouriteRepository userFavouriteRepository;

    public UserFavouriteServiceImpl(UserFavouriteRepository userFavouriteRepository) {
        this.userFavouriteRepository = userFavouriteRepository;
    }

    @Override
    public List<UserFavourite> listUserFavourites() {
        return this.userFavouriteRepository.findAll();
    }
}
