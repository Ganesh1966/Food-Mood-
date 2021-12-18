package com.constructweek.foodmood.Service;

import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Entity.FoodMoods;
import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Recipe;
import com.constructweek.foodmood.Repository.FoodMoodRepository;
import com.constructweek.foodmood.Repository.FoodRepository;
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


      public Food addFood(Food food) {

          foodRepository.save(food);
          return food;
      }

      public List<Food> getFoodsbyMood(String moodname ){

          FoodMoods foodMood  =  foodMoodRepository.getFoodItemsbyMood(moodname);
          return foodRepository.getFoodsBymoodId(foodMood.getFoodMoodId());
      }

}
