package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.User;

public interface AuthService {
    User login(String username, String password);
}

