package com.constructweek.foodmood.Repository;


import com.constructweek.foodmood.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface RecipeRepository extends JpaRepository<Recipe,Long> {


}
