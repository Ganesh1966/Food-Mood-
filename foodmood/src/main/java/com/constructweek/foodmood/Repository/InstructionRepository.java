package com.constructweek.foodmood.Repository;


import com.constructweek.foodmood.Entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface InstructionRepository  extends JpaRepository<Instruction,Long> {

}
