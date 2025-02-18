package com.su.ac.th.workshop.controller;

import com.su.ac.th.workshop.model.request.PokemonRequest;
import com.su.ac.th.workshop.model.response.BaseResponse;
import com.su.ac.th.workshop.model.response.PokemonResponse;
import com.su.ac.th.workshop.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/pokemon")
    public ResponseEntity<BaseResponse<List<PokemonResponse>>> getPokemon() {
        return ResponseEntity.ok(BaseResponse.<List<PokemonResponse>>builder()
                .status(200L)
                .message("Success")
                .data(pokemonService.getAllPokemon())
                .build());
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<BaseResponse<PokemonResponse>> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.<PokemonResponse>builder()
                .status(200L)
                .message("Success")
                .data(pokemonService.getPokemonById(id))
                .build());
    }

    @PostMapping("/pokemon")
    public ResponseEntity<BaseResponse<Void>> createPokemon(@RequestBody PokemonRequest pokemonRequest) {
        pokemonService.createPokemon(pokemonRequest);
        return ResponseEntity.ok(BaseResponse.<Void>builder()
                .status(200L)
                .message("Success")
                .build());
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<BaseResponse<Void>> updatePokemon(@PathVariable Long id, @RequestBody PokemonRequest pokemonRequest) {
        pokemonService.updatePokemon(id, pokemonRequest);
        return ResponseEntity.ok(BaseResponse.<Void>builder()
                .status(200L)
                .message("Success")
                .build());
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<BaseResponse<Void>> deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.ok(BaseResponse.<Void>builder()
                .status(200L)
                .message("Success")
                .build());
    }





}
