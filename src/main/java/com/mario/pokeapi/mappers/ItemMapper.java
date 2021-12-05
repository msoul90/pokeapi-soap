package com.mario.pokeapi.mappers;

import com.mario.pokeapi.soap.Item;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item restToSoap(com.mario.pokeapi.models.Item item);
    
}
