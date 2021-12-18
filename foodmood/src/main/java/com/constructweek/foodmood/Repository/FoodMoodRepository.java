package com.constructweek.foodmood.Repository;


import com.constructweek.foodmood.Entity.FoodMoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMoodRepository extends JpaRepository<FoodMoods,Long> {


    @Query(value = "SELECT * from food_moods fm where fm.name=?1",nativeQuery = true)
    public FoodMoods getFoodItemsbyMood(String moodname);

}
