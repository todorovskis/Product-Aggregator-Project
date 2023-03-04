package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.UserFavourite;

import java.util.List;

public interface UserFavouriteService {

    List<UserFavourite> listUserFavourites();

    List<UserFavourite> listByUserId(Integer userId);

    UserFavourite addProductToUserFavourites(Integer userId, Integer productId);
}
