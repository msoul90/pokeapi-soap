package com.mario.pokeapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonHeldItemVersion {
    private int rarity;
    private Version version;

}
