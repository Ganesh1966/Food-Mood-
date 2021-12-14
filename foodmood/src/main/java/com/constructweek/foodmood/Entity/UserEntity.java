package com.constructweek.foodmood.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    Long userId;
    String userName;
    String password;
    String email;
}
