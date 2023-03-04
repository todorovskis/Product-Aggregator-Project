package com.example.product_aggregator_project.repository;

import com.example.product_aggregator_project.model.UserFavourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavourite, Integer> {

    List<UserFavourite> findAllByUserId(Integer userId);
}
