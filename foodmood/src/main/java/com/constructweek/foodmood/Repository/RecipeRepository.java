package com.constructweek.foodmood.Repository;


import com.constructweek.foodmood.Entity.Food;
import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

}
