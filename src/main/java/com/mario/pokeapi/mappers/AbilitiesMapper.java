package com.mario.pokeapi.mappers;

import java.util.List;

import com.mario.pokeapi.models.PokemonAbility;
import com.mario.pokeapi.soap.Abilities;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbilitiesMapper {

    Abilities pokemonAbilityToAbilities(PokemonAbility abilities);

    List<Abilities> pokemonAbilityToAbilities(List<PokemonAbility> abilities);

    
}
