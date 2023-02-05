package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerManufacturer;
import com.example.product_aggregator_project.model.admin_panel.ProductDetailsPerStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsPerStoreRepository extends JpaRepository<ProductDetailsPerStore, Integer> {

    @Query(value = "select\n" +
            "\t s.store_id,\n" +
            "\t s.store_name,\n" +
            "\t \n" +
            "\t min(p.product_instance_price) as min_price,\n" +
            "\t \n" +
            "\t max(p.product_instance_price) as max_price,\n" +
            "\t \n" +
            "\t round(avg(p.product_instance_price)) as avg_price\n" +
            "from\n" +
            "\tproject.stores s\n" +
            "\tinner join project.productinstances p on (p.store_id = s.store_id)\n" +
            "\t\n" +
            "group by\n" +
            "\ts.store_id,\n" +
            "\ts.store_name\n" +
            "order by\n" +
            "\tavg(p.product_instance_price)",
            nativeQuery = true)
    List<ProductDetailsPerStore> findProductDetailsPerStore();
}
