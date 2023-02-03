package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Role;
import com.example.product_aggregator_project.repository.RoleRepository;
import com.example.product_aggregator_project.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> listRoles() {
        return this.roleRepository.findAll();
    }
}
