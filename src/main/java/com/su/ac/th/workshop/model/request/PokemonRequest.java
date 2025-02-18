package com.su.ac.th.workshop.model.request;

import lombok.Data;

@Data
public class PokemonRequest {

    private String pName;
    private String pType;
    private Long pHeight;
    private Long pWeight;
    private Long pHp;
    private Long pAttack;
    private Long pDefense;

}
