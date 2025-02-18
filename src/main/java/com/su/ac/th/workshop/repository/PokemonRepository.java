package com.su.ac.th.workshop.repository;

import com.su.ac.th.workshop.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
}
