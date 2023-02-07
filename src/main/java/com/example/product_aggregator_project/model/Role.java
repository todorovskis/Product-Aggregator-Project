package com.example.product_aggregator_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(unique = true)
    private String roleName;

    private String roleDescription;

    public Role() {
    }

    public Role(Integer id, String roleDescription, String roleName) {
        this.id = id;
        this.roleDescription = roleDescription;
        this.roleName = roleName;
    }
}
