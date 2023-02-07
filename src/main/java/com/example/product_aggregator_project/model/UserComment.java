package com.example.product_aggregator_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usercomments")
public class UserComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    private String userComment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public UserComment() {
    }

    public UserComment(Integer id, String userComment, User user, Product product) {
        this.id = id;
        this.userComment = userComment;
        this.user = user;
        this.product = product;
    }

}
