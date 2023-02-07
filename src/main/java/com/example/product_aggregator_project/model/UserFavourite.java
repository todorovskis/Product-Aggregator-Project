package com.example.product_aggregator_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userfavourites")
public class UserFavourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_favourite_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public UserFavourite() {
    }

    public UserFavourite(Integer id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }
}
