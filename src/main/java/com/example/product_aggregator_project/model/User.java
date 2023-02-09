package com.example.product_aggregator_project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_username", unique = true)
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_picture_url")
    private String pictureUrl;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user")
    private List<UserComment> userComments;

    @OneToMany(mappedBy = "user")
    private List<UserFavourite> userFavourites;

    @OneToMany(mappedBy = "user")
    private List<WatchListProduct> watchListProducts;

    public User() {
    }

    public User(Integer id, String username, String password, String name, String surname, String pictureUrl, String email, String phoneNumber, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pictureUrl = pictureUrl;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }


    public User(String username, String password, String name, String surname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}
