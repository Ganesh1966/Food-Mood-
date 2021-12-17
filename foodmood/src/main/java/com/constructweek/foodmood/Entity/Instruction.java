package com.constructweek.foodmood.Entity;


import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Data
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instructId;

    private String instruction;

    @ManyToOne
    @JoinColumn(name ="recipe_id")
    private Recipe recipe;

}
