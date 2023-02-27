package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Role;
import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.product_aggregator_project.model.exceptions.PasswordsDoNotMatchException;
import com.example.product_aggregator_project.model.exceptions.RoleIdNotFoundException;
import com.example.product_aggregator_project.model.exceptions.UsernameAlreadyExistsException;
import com.example.product_aggregator_project.repository.RoleRepository;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name,
                         String surname, String email, String phoneNumber, Integer roleId) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByEmail(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        Role userRole = this.roleRepository.findById(roleId)
                .orElseThrow(RoleIdNotFoundException::new);

        User user = new User(username, password, name, surname, email, phoneNumber, userRole);
        return userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        String userRole = null;
        if(user.getRole().getRoleName().equals("Administrator")){
            userRole = "ADMIN";
        }
        else{
            userRole = "USER";
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails
                .User(user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + userRole)));

        return userDetails;
    }
}
