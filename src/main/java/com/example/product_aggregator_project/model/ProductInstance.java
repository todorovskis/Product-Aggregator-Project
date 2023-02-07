package com.example.product_aggregator_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
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
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public ProductInstance() {
    }

    public ProductInstance(Integer id, Integer price, Product product, Store store) {
        this.id = id;
        this.price = price;
        this.product = product;
        this.store = store;
    }
}
