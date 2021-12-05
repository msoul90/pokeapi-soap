package com.mario.pokeapi.mappers;

import java.util.List;

import com.mario.pokeapi.models.PokemonRest;
import com.mario.pokeapi.soap.Pokemon;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokemonMapper {
    
    @Mapping(target = "abilities", ignore = true)
    @Mapping(target = "heldItems", ignore = true)
    Pokemon restToSoap(PokemonRest pokemon);

    List<Pokemon> restToSoap(List<PokemonRest> pokemons);
    
}
