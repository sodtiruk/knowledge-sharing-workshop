package com.su.ac.th.workshop.component;

import com.su.ac.th.workshop.entity.PokemonEntity;
import com.su.ac.th.workshop.model.request.PokemonRequest;
import com.su.ac.th.workshop.model.response.PokemonResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonComponent {

    public List<PokemonResponse> transformListPokemonEntityToListResponse(List<PokemonEntity> pokemonEntityList) {
        List<PokemonResponse> pokemonResponsesList = new ArrayList<>();

        for (PokemonEntity entity : pokemonEntityList) {
            PokemonResponse pokemonResponses = this.transformPokemonEntityToResponse(entity);
            pokemonResponsesList.add(pokemonResponses);
        }
        return pokemonResponsesList;
    }

    public PokemonResponse transformPokemonEntityToResponse(PokemonEntity entity) {
        PokemonResponse response = new PokemonResponse();
        response.setPId(entity.getPId());
        response.setPName(entity.getPName());
        response.setPType(entity.getPType());
        response.setPHeight(entity.getPHeight());
        response.setPWeight(entity.getPWeight());
        response.setPHp(entity.getPHp());
        response.setPAttack(entity.getPAttack());
        response.setPDefense(entity.getPDefense());
        return response;
    }

    public PokemonEntity transformPokemonRequestToPokemonEntity(PokemonRequest pokemonRequest){
        PokemonEntity entity = new PokemonEntity();
        entity.setPName(pokemonRequest.getPName());
        entity.setPType(pokemonRequest.getPType());
        entity.setPHeight(pokemonRequest.getPHeight());
        entity.setPWeight(pokemonRequest.getPWeight());
        entity.setPHp(pokemonRequest.getPHp());
        entity.setPAttack(pokemonRequest.getPAttack());
        entity.setPDefense(pokemonRequest.getPDefense());
        return entity;
    }

    public List<PokemonEntity> transformListPokemonRequestToListPokemonEntity(List<PokemonRequest> pokemonRequestList){
        List<PokemonEntity> pokemonEntityList = new ArrayList<>();
        for (PokemonRequest request : pokemonRequestList) {
            PokemonEntity entity = this.transformPokemonRequestToPokemonEntity(request);
            pokemonEntityList.add(entity);
        }
        return pokemonEntityList;
    }



}
