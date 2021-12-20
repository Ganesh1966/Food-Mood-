package com.constructweek.foodmood.Controller;


import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Instruction;
import com.constructweek.foodmood.Service.FoodService;
import com.constructweek.foodmood.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

     @Autowired
     FoodService foodService;

     @Autowired
    RecipeService recipeService;

     @PostMapping("/addFood/{food_mood}")
     public ResponseEntity<Food> addFood(@RequestBody Food food, @PathVariable("food_mood") String foodMood){
         Food food1 =  foodService.addFood(food,foodMood);
         return new ResponseEntity<>(food1, HttpStatus.OK);
     }



     @GetMapping("/foodbymood/{mood_name}")
     public ResponseEntity<List<Food>> getFoodItemsbyMood(@PathVariable("mood_name") String moodName){

         List<Food> foodList = foodService.getFoodsbyMood(moodName);
         return  new ResponseEntity<>(foodList,HttpStatus.OK);
     }

    @GetMapping("/getIngredients/{food_id}")
    public ResponseEntity<List<Ingredient>> getIngredients(@PathVariable("food_id") Long foodId){
         List<Ingredient> ingredientList = recipeService.getIngredients(foodId);
         return  new ResponseEntity<>(ingredientList,HttpStatus.OK);
    }

    @PostMapping("/addIngredients/{food_id}")
    public ResponseEntity<String> addIngredients(@RequestBody Ingredient ingredient ,@PathVariable("food_id") Long foodId){
     boolean check = recipeService.addIngredient(ingredient,foodId);

      if(check){
          String msg = "Ingredient added Successfully";
          return new ResponseEntity<>(msg,HttpStatus.CREATED);
      }else{
          String msg = "Failed to  add Ingredient ";
          return new ResponseEntity<>(msg,HttpStatus.NOT_IMPLEMENTED);
      }

    }

    @PostMapping("/addInstruction/{food_id}")
    public ResponseEntity<String> addInstruction(@RequestBody Instruction instruction ,@PathVariable("food_id") Long foodId){
        boolean check = recipeService.addInstruction(instruction,foodId);
        if(check){
            String msg = "Instruction added Successfully";
            return new ResponseEntity<>(msg,HttpStatus.CREATED);
        }else{
            String msg = "Failed to  add Instruction ";
            return new ResponseEntity<>(msg,HttpStatus.NOT_IMPLEMENTED);
        }

    }


    @GetMapping("/getInstructions/{food_id}")
    public  ResponseEntity<List<Instruction>> getInstructions(@PathVariable("food_id") Long foodId){

             List<Instruction> instructionList = recipeService.getInstructions(foodId);
             return new ResponseEntity<>(instructionList,HttpStatus.OK);
    }

}
