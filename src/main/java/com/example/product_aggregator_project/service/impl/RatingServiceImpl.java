package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Rating;
import com.example.product_aggregator_project.repository.RatingRepository;
import com.example.product_aggregator_project.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> listRatings() {
        return this.ratingRepository.findAll();
    }
}
