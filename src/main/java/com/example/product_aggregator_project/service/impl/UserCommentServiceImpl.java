package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.UserComment;
import com.example.product_aggregator_project.repository.UserCommentRepository;
import com.example.product_aggregator_project.service.UserCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService {

    private final UserCommentRepository userCommentRepository;

    public UserCommentServiceImpl(UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }

    @Override
    public List<UserComment> listUserComments() {
        return this.userCommentRepository.findAll();
    }
}
