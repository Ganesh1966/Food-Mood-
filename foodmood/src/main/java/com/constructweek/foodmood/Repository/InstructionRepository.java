package com.constructweek.foodmood.Repository;


import com.constructweek.foodmood.Entity.Ingredient;
import com.constructweek.foodmood.Entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface InstructionRepository  extends JpaRepository<Instruction,Long> {

    @Query(value = "SELECT * from instruction in where in.recipe_id =?1 order by instruction_no asc ", nativeQuery = true)
    public List<Instruction> getInstructionsByRecipeId(Long recipeID);


}
