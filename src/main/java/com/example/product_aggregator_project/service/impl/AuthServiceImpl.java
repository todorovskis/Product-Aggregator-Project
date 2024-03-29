package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.model.exceptions.InvalidArgumentsException;
import com.example.product_aggregator_project.model.exceptions.InvalidUserCredentialsException;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                passwordEncoder.encode(password)).orElseThrow(InvalidUserCredentialsException::new);
    }

}

