package com.constructweek.foodmood.Controller;


import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Instruction;
import com.constructweek.foodmood.Service.FoodService;
import com.constructweek.foodmood.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

     @Autowired
     FoodService foodService;

     @Autowired
    RecipeService recipeService;

     @PostMapping("/addFood")
     public Food addFood(@RequestBody Food food){
         return  foodService.addFood(food);
     }



     @GetMapping("/foodbymood/{mood_name}")
     public List<Food> getFoodItemsbyMood(@PathVariable("mood_name") String moodName){

         List<Food> foodList = foodService.getFoodsbyMood(moodName);
         return  foodList;
     }

    @GetMapping("/getIngredients/{food_id}")
    public List<Ingredient> getIngredients(@PathVariable("food_id") Long foodId){
         List<Ingredient> ingredientList = recipeService.getIngredients(foodId);
         return  ingredientList;
    }

    @GetMapping("/getInstructions/{food_id}")
    public  List<Instruction> getInstructions(@PathVariable("food_id") Long foodId){
         List<Instruction> instructionList = recipeService.getInstructions(foodId);
         return  instructionList;
    }

}
