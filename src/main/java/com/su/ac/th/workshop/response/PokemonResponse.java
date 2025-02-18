package com.su.ac.th.workshop.response;

import lombok.Data;

@Data
public class PokemonResponse {

    private Long pId;
    private String pName;
    private String pType;
    private Long pHeight;
    private Long pWeight;
    private Long pHp;
    private Long pAttack;
    private Long pDefense;


}
