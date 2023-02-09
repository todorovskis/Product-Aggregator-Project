package com.example.product_aggregator_project.service;

import com.example.product_aggregator_project.model.Role;
import com.example.product_aggregator_project.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User register(String username, String password, String repeatPassword, String name, String surname, String email, String phoneNumber, Integer roleId);


    UserDetails loadUserByUsername(String username);
}
