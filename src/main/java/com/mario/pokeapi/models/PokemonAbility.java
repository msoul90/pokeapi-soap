package com.mario.pokeapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonAbility {
    private Ability ability;
    private boolean isHidden;
    private int slot;
}
