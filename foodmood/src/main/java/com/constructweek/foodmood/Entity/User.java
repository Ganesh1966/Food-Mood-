package com.constructweek.foodmood.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String newPassword;
}
