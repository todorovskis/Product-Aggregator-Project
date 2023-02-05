package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.MostFavouriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminPanelRepositoryQuery6 extends JpaRepository<MostFavouriteProduct, Integer> {

    @Query(value = "select\n" +
            "\tq1.product_id,\n" +
            "\tp.product_name,\n" +
            "\tq1.num_users_favourite\n" +
            "from\n" +
            "\t (\n" +
            "\t \tselect\n" +
            "\t \t\tuf.product_id as product_id,\n" +
            "\t \t\tcount(*) as num_users_favourite\n" +
            "\t \tfrom\n" +
            "\t \t\tproject.userfavourites as uf\n" +
            "\t\t\tgroup by\n" +
            "\t\t\t\t  uf.product_id\n" +
            "\t\t\torder by\n" +
            "\t\t\t\t  num_users_favourite desc\n" +
            "\t\t\tfetch first rows with ties\n" +
            "\t \n" +
            "\t ) as q1\n" +
            "\tinner join project.products as p on (p.product_id = q1.product_id)\n" +
            "\torder by\n" +
            "\t\t  q1.product_id desc",
            nativeQuery = true)
    List<MostFavouriteProduct> findMostFavouriteProducts();
}
