package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Role;
import com.example.product_aggregator_project.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User register(String username, String password, String repeatPassword, String name, String surname, Integer roleId);

}
