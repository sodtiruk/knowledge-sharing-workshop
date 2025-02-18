package com.su.ac.th.workshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "pokemon")
@Data
public class PokemonEntity {

    @Id
    private Long pId;
    private String pName;
    private String pType;
    private Long pHeight;
    private Long pWeight;
    private Long pHp;
    private Long pAttack;
    private Long pDefense;


}
