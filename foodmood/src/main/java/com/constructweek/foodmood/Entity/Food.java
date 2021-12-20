package com.constructweek.foodmood.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;
    private String foodName;
    private String imageUrl;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "foodmood_id")
    private FoodMoods foodMoods;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
