package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.StoresWithAllManufacturerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresWithAllManufacturerProductsRepository extends JpaRepository<StoresWithAllManufacturerProducts, Integer> {


    @Query(value = "select\n" +
            "\tq1.manufacturer_id,\n" +
            "\tq1.manufacturer_name,\n" +
            "\tq2.store_name, \n" +
            "\tq1.num_products_per_manfucturer, \n" +
            "\tq2.num_products_in_store_per_manufacturer\n" +
            "from\n" +
            "\t(\n" +
            "\t\tselect\n" +
            "\t\t\tm.manufacturer_id,\n" +
            "\t\t\tm.manufacturer_name,\n" +
            "\t\t\tcount(*) as num_products_per_manfucturer\n" +
            "\t\tfrom\n" +
            "\t\t\tproject.manufacturers as m\n" +
            "\t\t\tinner join project.products as p on (p.manufacturer_id = m.manufacturer_id)\n" +
            "\t\tgroup by\n" +
            "\t\t\tm.manufacturer_id,\n" +
            "\t\t\tm.manufacturer_name\n" +
            "\t) as q1\n" +
            "\t\n" +
            "\tinner join \n" +
            "\n" +
            "\t(\n" +
            "\t\tselect\n" +
            "\t\t\ts.store_name,\n" +
            "\t\t\tm.manufacturer_id,\n" +
            "\t\t\tcount(distinct p.product_id) as num_products_in_store_per_manufacturer\n" +
            "\t\tfrom\n" +
            "\t\t\tproject.stores as s\n" +
            "\t\t\tinner join project.productinstances as p on (p.store_id = s.store_id)\n" +
            "\t\t\tinner join project.products as p2 on (p2.product_id = p.product_id)\n" +
            "\t\t\tinner join project.manufacturers as m on (m.manufacturer_id = p2.manufacturer_id)\n" +
            "\t\tgroup by\n" +
            "\t\t\ts.store_name,\n" +
            "\t\t\tm.manufacturer_id\n" +
            "\t) as q2\n" +
            "\t\n" +
            "\ton (q1.manufacturer_id = q2.manufacturer_id)\n" +
            "where\n" +
            "\t(q1.num_products_per_manfucturer = q2.num_products_in_store_per_manufacturer)\n" +
            "order by\n" +
            "\tq1.manufacturer_name",
            nativeQuery = true)
    List<StoresWithAllManufacturerProducts> findStoresWithAllManufacturerProducts();
}
