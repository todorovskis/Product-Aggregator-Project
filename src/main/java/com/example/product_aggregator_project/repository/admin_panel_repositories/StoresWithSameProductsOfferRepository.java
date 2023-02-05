package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.StoresWithSameProductsOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresWithSameProductsOfferRepository extends JpaRepository<StoresWithSameProductsOffer, Integer> {

    @Query(value = "select\n" +
            "\ts.store_id,\n" +
            "\ts.store_name,\n" +
            "\tq4.num_products\n" +
            "from\n" +
            "\t(\n" +
            "\t\tselect\n" +
            "\t\t\tq3.store_id,\n" +
            "\t\t\tcount(*) as num_products\n" +
            "\t\tfrom\n" +
            "\t\t(\t\n" +
            "\t\t\tselect distinct\n" +
            "\t\t\t\tp.store_id,\n" +
            "\t\t\t\tp.product_id as product_id_1\n" +
            "\t\t\tfrom\n" +
            "\t\t\t\t project.productinstances as p\n" +
            "\t\t\twhere\n" +
            "\t\t\t\tp.store_id = 1\n" +
            "\t\t) as q2\n" +
            "\t\t\n" +
            "\t\tinner join\n" +
            "\t\t\n" +
            "\t\t(\n" +
            "\t\t\tselect distinct\n" +
            "\t\t\t\tp.store_id,\n" +
            "\t\t\t\tp.product_id as product_id_2\n" +
            "\t\t\tfrom\n" +
            "\t\t\t\t project.productinstances as p\n" +
            "\t\t\twhere\n" +
            "\t\t\t\tp.store_id != 1\n" +
            "\t\t\n" +
            "\t\t) as q3 \n" +
            "\t\ton (q3.product_id_2 = q2.product_id_1)\n" +
            "\t\tgroup by\n" +
            "\t\t\tq3.store_id\n" +
            "\t\thaving\n" +
            "\t\t\t(count(*) = project.get_store_product_count(1)) \n" +
            "\t\t\n" +
            "\t) as q4\n" +
            "\t\n" +
            "\tinner join project.stores as s on (q4.store_id = s.store_id)\n",
                nativeQuery = true)
    List<StoresWithSameProductsOffer> findStoresWithSameProductsOffer();
}
