package com.constructweek.foodmood.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recipeId;

    private String preptime;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredient;

    @OneToMany(mappedBy = "recipe")
    private  List<Instruction> instructions;


}
