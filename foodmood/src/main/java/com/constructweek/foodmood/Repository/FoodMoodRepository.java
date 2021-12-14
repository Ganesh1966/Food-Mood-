package com.constructweek.foodmood.Repository;


import com.constructweek.foodmood.Entity.FoodMoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMoodRepository extends JpaRepository<FoodMoods,Long> {

}
