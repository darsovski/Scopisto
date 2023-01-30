package com.petshop.scopisto.model;


import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {


    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private String id;

    private String FirstName;
    private String LastName;
    private String email;
    private Integer money;

    public User() {};

    public User(String FirstName,String LastName,String email, Integer money) {
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.email=email;
        this.money=money;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getMoney() {
        return money;
    }
}
