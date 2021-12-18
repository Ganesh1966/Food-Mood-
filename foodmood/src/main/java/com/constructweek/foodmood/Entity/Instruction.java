package com.constructweek.foodmood.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Data
public class Instruction {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instructId;
    private int  instruction_no;
    private String instruction;


    @ManyToOne
    @JoinColumn(name ="recipe_id")
    @JsonIgnore
    private Recipe recipe;

}
