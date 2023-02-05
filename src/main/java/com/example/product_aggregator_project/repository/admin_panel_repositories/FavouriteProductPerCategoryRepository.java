package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.FavouriteProductPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteProductPerCategoryRepository extends JpaRepository<FavouriteProductPerCategory, Integer> {

    @Query(value = "select\n" +
            "\tq2.category_id,\n" +
            "\tq2.category_name,\n" +
            "\tq2.product_name,\n" +
            "\tq2.num_users_favourite\n" +
            "from\n" +
            "\t(\n" +
            "\t\tselect\n" +
            "\t\t\tc.category_id,\n" +
            "\t\t\tc.category_name,\n" +
            "\t\t\tq1.product_id,\n" +
            "\t\t\tp.product_name,\n" +
            "\t\t\tq1.num_users_favourite,\n" +
            "\t\t\trow_number () over\n" +
            "\t\t\t(\n" +
            "\t\t\t\tpartition by\n" +
            "\t\t\t\t\tc.category_id \n" +
            "\t\t\t\torder by\n" +
            "\t\t\t\t\tq1.num_users_favourite desc\n" +
            "\t\t\t) as rank_num\n" +
            "\t\tfrom\n" +
            "\t\t\t (\n" +
            "\t\t\t \tselect\n" +
            "\t\t\t \t\tuf.product_id as product_id,\n" +
            "\t\t\t \t\tcount(*) as num_users_favourite\n" +
            "\t\t\t \tfrom\n" +
            "\t\t\t \t\tproject.userfavourites as uf\n" +
            "\t\t\t\tgroup by\n" +
            "\t\t\t\t\tuf.product_id\n" +
            "\t\t\t\torder by\n" +
            "\t\t\t\t\tnum_users_favourite desc\n" +
            "\t\t\t ) as q1\n" +
            "\t\t\tinner join project.products as p on (p.product_id = q1.product_id)\n" +
            "\t\t\tinner join project.categories as c on (c.category_id = p.category_id)\n" +
            "\t) as q2\n" +
            "where\n" +
            "\tq2.rank_num = 1\n" +
            "order by \n" +
            "\tq2.category_name",
            nativeQuery = true)
    List<FavouriteProductPerCategory> findFavouriteProductsPerCategory();
}
