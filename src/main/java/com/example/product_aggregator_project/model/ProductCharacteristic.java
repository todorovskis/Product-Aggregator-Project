package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "productcharacteristics")
public class ProductCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Integer id;

    @Column(unique = true)
    private String characteristicDescription;

    @OneToOne(mappedBy = "characteristic")
    private Product product;

    public ProductCharacteristic() {
    }

    public ProductCharacteristic(Integer id, String characteristicDescription) {
        this.id = id;
        this.characteristicDescription = characteristicDescription;
    }

    public ProductCharacteristic(String characteristicDescription) {
        this.characteristicDescription = characteristicDescription;
    }

}

