package com.mario.pokeapi.mappers;

import java.util.List;

import com.mario.pokeapi.soap.PokemonAbility;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonAbilityMapper {

    PokemonAbility pokemonAbilityToAbilities(com.mario.pokeapi.models.PokemonAbility abilities);

    List<PokemonAbility> pokemonAbilityToAbilities(List<com.mario.pokeapi.models.PokemonAbility> abilities);

    
}
