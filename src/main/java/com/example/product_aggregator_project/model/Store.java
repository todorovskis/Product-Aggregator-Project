package com.example.product_aggregator_project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer id;

    @Column(name = "store_name")
    private String storeName;

    @OneToMany(mappedBy = "store")
    private List<ProductInstance> productInstances;

    public Store() {
    }

    public Store(Integer id, String storeName) {
        this.id = id;
        this.storeName = storeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
