package com.constructweek.foodmood.Repository;

import com.constructweek.foodmood.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository  extends JpaRepository<Food,Long> {
}
