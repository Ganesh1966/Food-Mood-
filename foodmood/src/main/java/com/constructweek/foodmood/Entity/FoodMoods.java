package com.constructweek.foodmood.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FoodMoods {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long foodMoodId;
     private String name;

     @OneToMany(mappedBy = "foodMoods", fetch = FetchType.EAGER)
     private List<Food> foodItems;

}
