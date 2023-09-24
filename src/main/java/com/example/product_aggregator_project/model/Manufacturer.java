package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Integer id;

    @Column(unique = true)
    private String manufacturerName;

    private String manufacturerCountry;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(Integer id, String manufacturerName, String manufacturerCountry) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.manufacturerCountry = manufacturerCountry;
    }

    public Manufacturer(String manufacturerName, String manufacturerCountry) {
        this.manufacturerName = manufacturerName;
        this.manufacturerCountry = manufacturerCountry;
    }
}
