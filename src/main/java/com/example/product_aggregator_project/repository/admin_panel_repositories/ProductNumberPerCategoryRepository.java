package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerManufacturer;
import com.example.product_aggregator_project.model.admin_panel.ProductNumberPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductNumberPerCategoryRepository extends JpaRepository<ProductNumberPerCategory, Integer> {

    @Query(value = "select\n" +
            "\tc.category_id,\n" +
            "\tc.category_name,\n" +
            "\tcount(*) as num_products\n" +
            "from\n" +
            "\tproject.categories c\n" +
            "\tinner join project.products p on (p.category_id = c.category_id)\n" +
            "group by\n" +
            "\tc.category_id\n" +
            "order by\n" +
            "\tnum_products desc",
            nativeQuery = true)
    List<ProductNumberPerCategory> findNumProductsPerCategory();

}
