package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.model.UserFavourite;
import com.example.product_aggregator_project.model.exceptions.ProductIdNotFoundException;
import com.example.product_aggregator_project.model.exceptions.UserIdNotFoundException;
import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.repository.UserFavouriteRepository;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.UserFavouriteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavouriteServiceImpl implements UserFavouriteService {

    private final UserFavouriteRepository userFavouriteRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserFavouriteServiceImpl(UserFavouriteRepository userFavouriteRepository,
                                    UserRepository userRepository,
                                    ProductRepository productRepository) {
        this.userFavouriteRepository = userFavouriteRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<UserFavourite> listUserFavourites() {
        return this.userFavouriteRepository.findAll();
    }

    @Override
    public List<UserFavourite> listByUserId(Integer userId) {
        return this.userFavouriteRepository.findAllByUserId(userId);
    }

    @Override
    public UserFavourite addProductToUserFavourites(Integer userId, Integer productId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(UserIdNotFoundException::new);
        Product product = this.productRepository.findById(productId)
                .orElseThrow(ProductIdNotFoundException::new);

        UserFavourite userFavourite = new UserFavourite(user, product);
        return this.userFavouriteRepository.save(userFavourite);
    }
}
