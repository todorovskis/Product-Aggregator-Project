package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails
                .User(user.getEmail(), passwordEncoder.encode(user.getPassword()),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRoleName())));

        return userDetails;
    }
}
