package com.example.product_aggregator_project.repository.admin_panel_repositories;

import com.example.product_aggregator_project.model.admin_panel.HighestAvgProductRatingPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighestAvgProductRatingPerCategoryRepository extends JpaRepository<HighestAvgProductRatingPerCategory, Integer> {


    @Query(value = "select\n" +
            "\tq2.category_id,\n" +
            "\tq2.category_name,\n" +
            "\tq2.product_name,\n" +
            "\tq2.avg_rating\n" +
            "from\n" +
            "\t(\n" +
            "\t\tselect\n" +
            "\t\t\tq1.category_id,\n" +
            "\t\t\tq1.category_name,\n" +
            "\t\t\tq1.product_name,\n" +
            "\t\t\tq1.avg_rating,\n" +
            "\t\t\trow_number () over\n" +
            "\t\t\t(\n" +
            "\t\t\t\tpartition by q1.category_name\n" +
            "\t\t\t\torder by q1.avg_rating desc\n" +
            "\t\t\t) as rank_num\n" +
            "\t\tfrom\n" +
            "\t\t(\n" +
            "\t\t\tselect\n" +
            "\t\t\t\tc.category_id,\n" +
            "\t\t\t\tc.category_name,\n" +
            "\t\t\t\tp.product_name, \n" +
            "\t\t\t\tavg(r.rating_value) as avg_rating\n" +
            "\t\t\tfrom\n" +
            "\t\t\t\tproject.products as p\n" +
            "\t\t\t\tinner join project.ratings as r on (r.product_id = p.product_id)\n" +
            "\t\t\t\tinner join project.categories as c on (c.category_id = p.category_id)\n" +
            "\t\t\twhere\n" +
            "\t\t\t\tp.post_date between current_date - interval '1 year' and current_date\n" +
            "\t\t\tgroup by \n" +
            "\t\t\t\tc.category_id,\n" +
            "\t\t\t\tc.category_name,\n" +
            "\t\t\t\tp.product_name\n" +
            "\t\t\torder by\n" +
            "\t\t\t\tavg_rating desc\n" +
            "\t\t) as q1\n" +
            "\t\n" +
            "\t) as q2\n" +
            "where\n" +
            "\tq2.rank_num = 1",
            nativeQuery = true)
    List<HighestAvgProductRatingPerCategory> findHighestAvgProductRatingPerCategory();
}
