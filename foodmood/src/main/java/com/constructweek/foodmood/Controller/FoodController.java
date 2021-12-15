package com.constructweek.foodmood.Controller;


import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

     @Autowired
     FoodService foodService;


     @PostMapping("/addFood")
     public Food addFood(@RequestBody Food food){
         return  foodService.addFood(food);
     }



     @GetMapping("/foodbymood/{mood_name}")
     public List<Food> getFoodItemsbyMood(@PathVariable("mood_name") String moodName){
       return foodService.getFoodsbyMood(moodName);
     }


}
