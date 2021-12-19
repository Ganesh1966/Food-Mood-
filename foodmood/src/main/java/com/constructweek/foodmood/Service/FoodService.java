package com.constructweek.foodmood.Service;

import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Entity.FoodMoods;
import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Recipe;
import com.constructweek.foodmood.Repository.FoodMoodRepository;
import com.constructweek.foodmood.Repository.FoodRepository;
import com.constructweek.foodmood.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

      @Autowired
      FoodRepository foodRepository;

      @Autowired
      FoodMoodRepository foodMoodRepository;

      @Autowired
      RecipeRepository recipeRepository;

      public String addFood(Food food,String moodname) {
          FoodMoods foodMood  =  foodMoodRepository.getFoodItemsbyMood(moodname);
          Recipe recipe = new Recipe();
          food.setRecipe(recipe);
          food.setFoodMoods(foodMood);
          recipeRepository.save(recipe);
          foodRepository.save(food);
          return "food Added";
      }

      public List<Food> getFoodsbyMood(String moodname ){

          FoodMoods foodMood  =  foodMoodRepository.getFoodItemsbyMood(moodname);
          return foodRepository.getFoodsBymoodId(foodMood.getFoodMoodId());
      }

}
