package com.su.ac.th.workshop.controller;

import com.su.ac.th.workshop.response.BaseResponse;
import com.su.ac.th.workshop.response.PokemonResponse;
import com.su.ac.th.workshop.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
