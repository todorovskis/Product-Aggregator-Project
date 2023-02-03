package com.example.product_aggregator_project.model;

import javax.persistence.*;

@Entity
@Table(name = "productinstances")
public class ProductInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_instance_id")
    private Integer id;

    @Column(name = "product_instance_price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public ProductInstance() {
    }

    public ProductInstance(Integer id, Integer price, Product product, Store store) {
        this.id = id;
        this.price = price;
        this.product = product;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
