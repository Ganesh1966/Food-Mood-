package com.constructweek.foodmood.Entity;


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

    @OneToMany
    private List<Ingredient> ingredient;

    @OneToMany
    private  List<Instruction> instructions;


}
