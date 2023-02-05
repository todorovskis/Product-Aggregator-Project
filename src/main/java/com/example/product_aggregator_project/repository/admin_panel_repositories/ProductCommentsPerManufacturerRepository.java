package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.ProductCommentsPerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsPerManufacturerRepository extends JpaRepository<ProductCommentsPerManufacturer, Integer> {

    @Query(value = "select\n" +
            "\tm.manufacturer_id,\n" +
            "\tm.manufacturer_name,\n" +
            "\tp.product_name,\n" +
            "\t(\n" +
            "\t\tselect count(*)\n" +
            "\t\tfrom\n" +
            "\t\t\tproject.usercomments u\n" +
            "\t\twhere\n" +
            "\t\t\tu.product_id = p.product_id\n" +
            "\t\n" +
            "\t) as num_comments,\n" +
            "\t\n" +
            "\t(\n" +
            "\t\tselect avg(r.rating_value)\n" +
            "\t\tfrom\n" +
            "\t\t\tproject.ratings r\n" +
            "\t\twhere \n" +
            "\t\t\tr.product_id  = p.product_id\n" +
            "\t\n" +
            "\t) as avg_rating\n" +
            "from\n" +
            "\tproject.manufacturers m\n" +
            "\tinner join project.products p on (p.manufacturer_id = m.manufacturer_id)\n" +
            "order BY\n" +
            "\tavg_rating desc,\n" +
            "\tnum_comments desc",
            nativeQuery = true)
    List<ProductCommentsPerManufacturer> findProductCommentsPerManufacturer();
}
