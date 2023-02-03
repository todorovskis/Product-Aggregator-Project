package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return this.userRepository.findAll();
    }
}
