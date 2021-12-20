package com.constructweek.foodmood.Service;


import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Instruction;
import com.constructweek.foodmood.Entity.Recipe;
import com.constructweek.foodmood.Repository.FoodRepository;
import com.constructweek.foodmood.Repository.IngredientRepository;
import com.constructweek.foodmood.Repository.InstructionRepository;
import com.constructweek.foodmood.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    InstructionRepository instructionRepository;

    public List<Ingredient> getIngredients(Long foodId){

        Food food = foodRepository.findById(foodId).get();

        Recipe recipe = food.getRecipe();

        Long recipeId = recipe.getRecipeId();

        return ingredientRepository.getIngredientByRecipeId(recipeId);
    }

    public  List<Instruction> getInstructions(Long foodId){
        Food food = foodRepository.findById(foodId).get();

        Recipe recipe = food.getRecipe();

        Long recipeId = recipe.getRecipeId();

        return instructionRepository.getInstructionsByRecipeId(recipeId);
    }

    public boolean addIngredient(Ingredient ingredient,Long foodId){
        try {
            Food food = foodRepository.findById(foodId).get();

            Recipe recipe = food.getRecipe();

            ingredient.setRecipe(recipe);

            ingredientRepository.save(ingredient);
            return  true;
        }
        catch (Exception e){
            System.out.println(e);
            return  false;
        }
    }

    public boolean addInstruction(Instruction instruction,Long foodId){
       try{
           Food food = foodRepository.findById(foodId).get();
           Recipe recipe = food.getRecipe();
           instruction.setRecipe(recipe);

           instructionRepository.save(instruction);
           return true;
       }
         catch (Exception e){
             System.out.println(e);
             return  false;
         }
    }
}
