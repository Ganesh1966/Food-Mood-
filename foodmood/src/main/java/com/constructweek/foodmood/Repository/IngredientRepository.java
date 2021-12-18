package com.constructweek.foodmood.Repository;

import com.constructweek.foodmood.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    @Query(value = "SELECT * from ingredient in where in.recipe_id =?1", nativeQuery = true)
    public List<Ingredient> getIngredientByRecipeId(Long recipeID);


}
