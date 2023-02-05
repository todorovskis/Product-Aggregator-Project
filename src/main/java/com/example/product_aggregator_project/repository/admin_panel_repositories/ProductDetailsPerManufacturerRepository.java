package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsPerManufacturerRepository extends JpaRepository<ProductDetailsPerManufacturer, Integer> {

    @Query(value = "select\n" +
            "\tm.manufacturer_id,\n" +
            "\t\n" +
            "\tm.manufacturer_name,\n" +
            "\t\n" +
            "\tp.product_name,\n" +
            "\t\n" +
            "\tmin(p2.product_instance_price) as min_price,\n" +
            "\t\n" +
            "\tmax(p2.product_instance_price) as max_price,\n" +
            "\t\n" +
            "\tround(avg(p2.product_instance_price)) as avg_price\n" +
            "\t\n" +
            "from\n" +
            "\tproject.manufacturers m \n" +
            "\tinner join project.products p on (p.manufacturer_id = m.manufacturer_id)\n" +
            "\tinner join project.productinstances p2 on (p2.product_id = p.product_id)\n" +
            "\n" +
            "group by\n" +
            "\tm.manufacturer_id,\n" +
            "\tm.manufacturer_name,\n" +
            "\tp.product_name\n" +
            "order by\n" +
            "\tm.manufacturer_name,\n" +
            "\tp.product_name\n",
            nativeQuery = true)
    List<ProductDetailsPerManufacturer> findProductDetailsPerManufacturer();
}
