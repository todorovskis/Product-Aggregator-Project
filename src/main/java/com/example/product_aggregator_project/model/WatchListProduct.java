package com.example.product_aggregator_project.model;

import javax.persistence.*;

@Entity
@Table(name = "watchlistproducts")
public class WatchListProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watch_list_product_id")
    private Integer id;

    @Column(name = "price_limit")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(Integer priceLimit) {
        this.priceLimit = priceLimit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
