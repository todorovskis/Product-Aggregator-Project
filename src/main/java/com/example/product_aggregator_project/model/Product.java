package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(unique = true)
    private String productName;

    private LocalDate postDate;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "belongs_to",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToOne
    @JoinColumn(name = "characteristic_id", nullable = false)
    private ProductCharacteristic characteristic;

    @OneToMany(mappedBy = "product")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "product")
    private List<UserComment> userComments;

    @OneToMany(mappedBy = "product")
    private List<UserFavourite> userFavourites;

    @OneToMany(mappedBy = "product")
    private List<WatchListProduct> watchListProducts;

    @OneToMany(mappedBy = "product")
    private List<ProductInstance> productInstances;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    public Product() {

    }

    public Product(Integer id, String productName, LocalDate postDate, Manufacturer manufacturer, List<Category> categories, ProductCharacteristic characteristic) {
        this.id = id;
        this.productName = productName;
        this.postDate = postDate;
        this.manufacturer = manufacturer;
        this.categories = categories;
        this.characteristic = characteristic;
    }

    public Product(String productName, Category category, Manufacturer manufacturer, LocalDate postDate, ProductCharacteristic characteristic) {
        this.productName = productName;

        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(category);
        this.manufacturer = manufacturer;
        this.postDate = postDate;
        this.characteristic = characteristic;
    }

    public List<Store> getProductInstancesUniqueStores() {
        return productInstances.stream().distinct().map(ProductInstance::getStore).collect(Collectors.toList());
    }
}
