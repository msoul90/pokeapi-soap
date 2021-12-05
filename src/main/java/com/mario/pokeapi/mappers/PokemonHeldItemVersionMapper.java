package com.mario.pokeapi.mappers;

import java.util.List;

import com.mario.pokeapi.soap.PokemonHeldItemVersion;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonHeldItemVersionMapper {

    PokemonHeldItemVersion restToSoap(com.mario.pokeapi.models.PokemonHeldItemVersion pokemonHeldItemVersion);

    List<PokemonHeldItemVersion> restToSoap(List<com.mario.pokeapi.models.PokemonHeldItemVersion> pokemonHeldItemVersion);

    
}
