package com.constructweek.foodmood.Entity;

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
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int userId;
    String userName;
    String password;
    String email;
}
