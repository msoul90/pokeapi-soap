package com.mario.pokeapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonHeldItem {
    private Item item;
    @JsonAlias("version_details")
    private List<PokemonHeldItemVersion> versionDetails;
}
