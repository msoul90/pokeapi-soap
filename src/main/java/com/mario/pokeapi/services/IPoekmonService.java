package com.mario.pokeapi.services;

import com.mario.pokeapi.constants.Constants;

import java.util.List;

import com.mario.pokeapi.mappers.PokemonAbilityMapper;
import com.mario.pokeapi.mappers.PokemonHeldItemsMapper;
import com.mario.pokeapi.mappers.PokemonMapper;
import com.mario.pokeapi.models.PokemonAbility;
import com.mario.pokeapi.models.PokemonHeldItem;
import com.mario.pokeapi.models.PokemonRest;
import com.mario.pokeapi.repositories.PokemonRepository;
import com.mario.pokeapi.soap.Abilities;
import com.mario.pokeapi.soap.GetPokemonAbilitiesResponse;
import com.mario.pokeapi.soap.GetPokemonBaseExperienceResponse;
import com.mario.pokeapi.soap.GetPokemonHeldItemsResponse;
import com.mario.pokeapi.soap.GetPokemonIdResponse;
import com.mario.pokeapi.soap.GetPokemonLocationAreaEncountersResponse;
import com.mario.pokeapi.soap.GetPokemonNameResponse;
import com.mario.pokeapi.soap.GetPokemonResponse;
import com.mario.pokeapi.soap.HeldItems;
import com.mario.pokeapi.soap.Pokemon;
import com.mario.pokeapi.soap.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class IPoekmonService implements PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Autowired
    private PokemonAbilityMapper pokemonAbilityMapper;

    @Autowired
    private PokemonMapper pokemonMapper;

    @Autowired
    private PokemonHeldItemsMapper pokemonHeldItemsMapper;

    @Override
    public GetPokemonResponse getPokemon(String name) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();

        log.info("Name:{}", name);

        if (name == null || name.isEmpty()) {
            return null;
        }

        ResponseEntity<PokemonRest> response = repository.findPokemon(name);

        if (response.getStatusCodeValue() == 200) {

            PokemonRest pokemonRest = response.getBody();

            if (pokemonRest == null) {
                getPokemonResponse.setPokemon(null);
                getPokemonResponse.setStatus(generateStatus(false, Constants.POKEMON_ENCONTRADO));
                return getPokemonResponse;
            }

            Pokemon pokemonSoap = pokemonMapper.restToSoap(pokemonRest);

            pokemonSoap.setAbilities(getAbilities(pokemonRest.getAbilities()));
            pokemonSoap.setHeldItems(getHeldItems(pokemonRest.getHeldItems()));

            getPokemonResponse.setPokemon(pokemonSoap);
            getPokemonResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
            return getPokemonResponse;
        }

        getPokemonResponse.setPokemon(null);
        getPokemonResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
        return getPokemonResponse;
    }

    @Override
    public GetPokemonAbilitiesResponse getPokemonAbilities(String name) {
        GetPokemonAbilitiesResponse getPokemonAbilitiesResponse = new GetPokemonAbilitiesResponse();

        PokemonRest pokemonRest = findPokemon(name);

        if (pokemonRest == null) {
            getPokemonAbilitiesResponse.setAbilities(null);
            getPokemonAbilitiesResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
            return getPokemonAbilitiesResponse;
        }

        getPokemonAbilitiesResponse.setAbilities(getAbilities(pokemonRest.getAbilities()));
        getPokemonAbilitiesResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
        return getPokemonAbilitiesResponse;
    }

    @Override
    public GetPokemonBaseExperienceResponse getPokemonBaseExperience(String name) {

        GetPokemonBaseExperienceResponse getPokemonBaseExperienceResponse = new GetPokemonBaseExperienceResponse();

        PokemonRest pokemonRest = findPokemon(name);

        if (pokemonRest == null) {
            getPokemonBaseExperienceResponse.setBaseExperience(-1);
            getPokemonBaseExperienceResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
            return getPokemonBaseExperienceResponse;
        }

        getPokemonBaseExperienceResponse.setBaseExperience(pokemonRest.getBaseExperience());
        getPokemonBaseExperienceResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
        return getPokemonBaseExperienceResponse;
    }

    @Override
    public GetPokemonHeldItemsResponse getPokemonHeldItems(String name) {
        GetPokemonHeldItemsResponse getPokemonHeldItemsResponse = new GetPokemonHeldItemsResponse();

        PokemonRest pokemonRest = findPokemon(name);

        if (pokemonRest == null) {
            getPokemonHeldItemsResponse.setHeldItems(null);
            getPokemonHeldItemsResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
            return getPokemonHeldItemsResponse;
        }

        getPokemonHeldItemsResponse.setHeldItems(getHeldItems(pokemonRest.getHeldItems()));
        getPokemonHeldItemsResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
        return getPokemonHeldItemsResponse;
    }

    @Override
    public GetPokemonIdResponse getPokemonId(String name) {
        GetPokemonIdResponse getPokemonIdResponse = new GetPokemonIdResponse();

        PokemonRest pokemonRest = findPokemon(name);

        if (pokemonRest == null) {
            getPokemonIdResponse.setId(-1);
            getPokemonIdResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
            return getPokemonIdResponse;
        }

        getPokemonIdResponse.setId(pokemonRest.getId());
        getPokemonIdResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
        return getPokemonIdResponse;
    }

    @Override
    public GetPokemonNameResponse getPokemonName(String name) {
        GetPokemonNameResponse getPokemonNameResponse = new GetPokemonNameResponse();

        PokemonRest pokemonRest = findPokemon(name);

        if (pokemonRest == null) {
            getPokemonNameResponse.setName(null);
            getPokemonNameResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
            return getPokemonNameResponse;
        }

        getPokemonNameResponse.setName(pokemonRest.getName());
        getPokemonNameResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
        return getPokemonNameResponse;
    }

    @Override
    public GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(String name) {
        GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncountersResponse = new GetPokemonLocationAreaEncountersResponse();

        PokemonRest pokemonRest = findPokemon(name);

        if (pokemonRest == null) {
            getPokemonLocationAreaEncountersResponse.setLocationAreaEncounters(null);
            getPokemonLocationAreaEncountersResponse.setStatus(generateStatus(false, Constants.POKEMON_NO_ENCONTRADO));
            return getPokemonLocationAreaEncountersResponse;
        }

        getPokemonLocationAreaEncountersResponse.setLocationAreaEncounters(pokemonRest.getLocationAreaEncounters());
        getPokemonLocationAreaEncountersResponse.setStatus(generateStatus(true, Constants.POKEMON_ENCONTRADO));
        return getPokemonLocationAreaEncountersResponse;
    }

    private Abilities getAbilities(List<PokemonAbility> listAbilities) {
        Abilities abilities = new Abilities();
        pokemonAbilityMapper.pokemonAbilityToAbilities(listAbilities)
                .forEach(x -> abilities.getPokemonAbility().add(x));
        return abilities;
    }

    private HeldItems getHeldItems(List<PokemonHeldItem> listHeldItems) {
        HeldItems helditems = new HeldItems();
        pokemonHeldItemsMapper.restToSoap(listHeldItems)
                .forEach(x -> helditems.getPokemonHeldItem().add(x));
        return helditems;
    }

    private PokemonRest findPokemon(String name) {

        if (name == null || name.isEmpty()) {
            return null;
        }

        ResponseEntity<PokemonRest> response = repository.findPokemon(name);

        if (response.getStatusCodeValue() == 200) {
            PokemonRest pokemonRest = response.getBody();

            if (pokemonRest == null) {
                return null;
            }
            return pokemonRest;
        }
        return null;
    }

    private Status generateStatus(boolean isOk, String message) {
        Status status = new Status();
        status.setCode("ERROR");
        if (isOk) {
            status.setCode("OK");
        }
        status.setMessage(message);
        return status;
    }

}
