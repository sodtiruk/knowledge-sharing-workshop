package com.su.ac.th.workshop.service;

import com.su.ac.th.workshop.entity.PokemonEntity;
import com.su.ac.th.workshop.repository.PokemonRepository;
import com.su.ac.th.workshop.response.PokemonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public List<PokemonResponse> getAllPokemon() {

        List<PokemonEntity> pokemonEntity = pokemonRepository.findAll();
        List<PokemonResponse> pokemonResponses = new ArrayList<>();

        for (PokemonEntity entity : pokemonEntity) {
            PokemonResponse response = new PokemonResponse();
            response.setPId(entity.getPId());
            response.setPName(entity.getPName());
            response.setPType(entity.getPType());
            response.setPHeight(entity.getPHeight());
            response.setPWeight(entity.getPWeight());
            response.setPHp(entity.getPHp());
            response.setPAttack(entity.getPAttack());
            response.setPDefense(entity.getPDefense());
            pokemonResponses.add(response);
        }

        return pokemonResponses;
    }
}
