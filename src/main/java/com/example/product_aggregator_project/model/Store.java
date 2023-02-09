package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer id;

    @Column(unique = true)
    private String storeName;

    @OneToMany(mappedBy = "store")
    private List<ProductInstance> productInstances;

    public Store() {
    }

    public Store(Integer id, String storeName) {
        this.id = id;
        this.storeName = storeName;
    }

}
