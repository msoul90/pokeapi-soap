package com.mario.pokeapi.repositories;

import com.mario.pokeapi.models.PokemonRest;

import org.springframework.http.ResponseEntity;

public interface PokemonRepository {

    public ResponseEntity<PokemonRest> findPokemon(String name);

    public String findPokemonString(String name);

    
}
