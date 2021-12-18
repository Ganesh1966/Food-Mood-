package com.constructweek.foodmood.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ingredient{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long ingId;

    private String ingredientName;

    private String quantity;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


}
