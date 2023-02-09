package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(unique = true)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> subcategories;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
    }

    public Category(Integer id, String categoryName, Category parentCategory, List<Product> products) {
        this.id = id;
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
        this.products = products;
    }

}
