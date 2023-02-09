package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "watchlistproducts")
public class WatchListProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watch_list_product_id")
    private Integer id;

    private Integer priceLimit;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public WatchListProduct() {
    }

    public WatchListProduct(Integer id, Integer priceLimit, User user, Product product) {
        this.id = id;
        this.priceLimit = priceLimit;
        this.user = user;
        this.product = product;
    }
}
