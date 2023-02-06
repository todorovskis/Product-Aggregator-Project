package com.example.product_aggregator_project.model;

import javax.persistence.*;

@Entity
@Table(name = "productcharacteristics")
public class ProductCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Integer id;

    @Column(name = "characteristic_description", unique = true)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharacteristicDescription() {
        return characteristicDescription;
    }

    public void setCharacteristicDescription(String characteristicDescription) {
        this.characteristicDescription = characteristicDescription;
    }
}

