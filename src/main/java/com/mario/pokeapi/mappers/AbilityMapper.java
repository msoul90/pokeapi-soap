package com.mario.pokeapi.mappers;

import com.mario.pokeapi.soap.Ability;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbilityMapper {

    Ability restToSoap(com.mario.pokeapi.models.Ability abilities);
    
}
