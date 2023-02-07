package com.example.product_aggregator_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Integer id;

    private Integer ratingValue;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Rating() {
    }

    public Rating(Integer id, Integer ratingValue, User user, Product product) {
        this.id = id;
        this.ratingValue = ratingValue;
        this.user = user;
        this.product = product;
    }
}
