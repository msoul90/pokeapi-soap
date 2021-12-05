package com.mario.pokeapi.services;

import com.mario.pokeapi.soap.GetPokemonAbilitiesResponse;
import com.mario.pokeapi.soap.GetPokemonBaseExperienceResponse;
import com.mario.pokeapi.soap.GetPokemonHeldItemsResponse;
import com.mario.pokeapi.soap.GetPokemonIdResponse;
import com.mario.pokeapi.soap.GetPokemonLocationAreaEncountersResponse;
import com.mario.pokeapi.soap.GetPokemonNameResponse;
import com.mario.pokeapi.soap.GetPokemonResponse;

public interface PokemonService {

    public GetPokemonResponse getPokemon(String name);

    public GetPokemonAbilitiesResponse getPokemonAbilities(String name);

    public GetPokemonBaseExperienceResponse getPokemonBaseExperience(String name);

    public GetPokemonHeldItemsResponse getPokemonHeldItems(String name);

    public GetPokemonIdResponse getPokemonId(String name);

    public GetPokemonNameResponse getPokemonName(String name);

    public GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(String name);

}
