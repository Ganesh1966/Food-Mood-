package com.constructweek.foodmood.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    Long userId;
    String username;
    String password;
    String email;

    public User(Long userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }



}
