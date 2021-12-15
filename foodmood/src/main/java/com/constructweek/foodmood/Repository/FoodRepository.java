package com.constructweek.foodmood.Repository;

import com.constructweek.foodmood.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository  extends JpaRepository<Food,Long> {

    @Query(value = "SELECT * from food f where f.foodmood_id =?1", nativeQuery = true)
    public List<Food> getFoodsBymoodId(Long moodId);

}
