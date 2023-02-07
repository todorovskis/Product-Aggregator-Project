package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        User findByEmail(String email);
}
