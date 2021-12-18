package com.constructweek.foodmood.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


}
