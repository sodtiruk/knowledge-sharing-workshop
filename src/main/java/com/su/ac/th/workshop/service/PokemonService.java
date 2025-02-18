package com.su.ac.th.workshop.service;

import com.su.ac.th.workshop.component.PokemonComponent;
import com.su.ac.th.workshop.entity.PokemonEntity;
import com.su.ac.th.workshop.model.request.PokemonRequest;
import com.su.ac.th.workshop.model.response.PokemonResponse;
import com.su.ac.th.workshop.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonComponent pokemonComponent;

    public List<PokemonResponse> getAllPokemon() {
        List<PokemonEntity> pokemonEntity = pokemonRepository.findAll();
        return pokemonComponent.transformListPokemonEntityToListResponse(pokemonEntity);
    }

    public PokemonResponse getPokemonById(Long id) {
        PokemonEntity entity = pokemonRepository.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }
        return pokemonComponent.transformPokemonEntityToResponse(entity);
    }

    public void createPokemon(PokemonRequest pokemonRequest) {

        PokemonEntity entity = pokemonComponent.transformPokemonRequestToPokemonEntity(pokemonRequest);
        pokemonRepository.save(entity);

    }

    public void updatePokemon(Long id, PokemonRequest pokemonRequest) {
        PokemonEntity pokemonEntity = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found"));

        if (pokemonRequest.getPName() != null) {
            pokemonEntity.setPName(pokemonRequest.getPName());
        }
        if (pokemonRequest.getPType() != null) {
            pokemonEntity.setPType(pokemonRequest.getPType());
        }
        if (pokemonRequest.getPHeight() != null) {
            pokemonEntity.setPHeight(pokemonRequest.getPHeight());
        }
        if (pokemonRequest.getPWeight() != null) {
            pokemonEntity.setPWeight(pokemonRequest.getPWeight());
        }
        if (pokemonRequest.getPHp() != null) {
            pokemonEntity.setPHp(pokemonRequest.getPHp());
        }
        if (pokemonRequest.getPAttack() != null) {
            pokemonEntity.setPAttack(pokemonRequest.getPAttack());
        }
        if (pokemonRequest.getPDefense() != null) {
            pokemonEntity.setPDefense(pokemonRequest.getPDefense());
        }

        pokemonRepository.save(pokemonEntity);
    }

    public void deletePokemon(Long id) {
        PokemonEntity entity = pokemonRepository.findById(id).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Pokemon not found");
        }
        pokemonRepository.deleteById(id);
    }
}
