package com.mario.pokeapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRest {
    private List<PokemonAbility> abilities;
    @JsonAlias("base_experience")
    private int baseExperience;
    @JsonAlias("held_items")
    @JsonProperty("held_items")
    private List<PokemonHeldItem> heldItems;
    private String name;
    @JsonAlias("location_area_encounters")
    private String locationAreaEncounters;
    private int id;
}
