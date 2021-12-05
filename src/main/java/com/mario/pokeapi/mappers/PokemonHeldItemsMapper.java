package com.mario.pokeapi.mappers;

import java.util.List;

import com.mario.pokeapi.soap.PokemonHeldItem;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonHeldItemsMapper {

    PokemonHeldItem restToSoap(com.mario.pokeapi.models.PokemonHeldItem pokemonHeldItem);

    List<PokemonHeldItem> restToSoap(List<com.mario.pokeapi.models.PokemonHeldItem> pokemonHeldItem);
    
}
