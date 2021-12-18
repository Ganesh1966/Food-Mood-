package com.constructweek.foodmood.Repository;

import com.constructweek.foodmood.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
