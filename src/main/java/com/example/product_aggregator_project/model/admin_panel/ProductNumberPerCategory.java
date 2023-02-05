package com.example.product_aggregator_project.model.admin_panel;

import javax.persistence.*;

@Entity(name = "num_products_by_category")
//@SqlResultSetMapping(
//        name = "findNumProductsByCategoryMapping",
//        classes = @ConstructorResult(
//                targetClass = ProductNumberPerCategory.class,
//                columns= {@ColumnResult(name = "category_id", type = Integer.class),
//                            @ColumnResult(name = "category_name", type = String.class),
//                            @ColumnResult(name = "num_products", type = Long.class)}
//        )
//)
public class ProductNumberPerCategory {

    @Id
    private Integer categoryId;

    private String categoryName;

    private Long numProducts;

    public ProductNumberPerCategory() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(Long numProducts) {
        this.numProducts = numProducts;
    }
}
