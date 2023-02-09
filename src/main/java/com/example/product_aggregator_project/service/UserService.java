package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> listUsers();

    User register(String username, String password, String repeatPassword, String name, String surname, String pictureUrl, String email, String phoneNumber, Integer roleId);

}
