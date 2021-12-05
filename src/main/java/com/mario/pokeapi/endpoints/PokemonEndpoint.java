package com.mario.pokeapi.endpoints;

import com.mario.pokeapi.services.PokemonService;
import com.mario.pokeapi.soap.GetPokemonAbilitiesRequest;
import com.mario.pokeapi.soap.GetPokemonAbilitiesResponse;
import com.mario.pokeapi.soap.GetPokemonBaseExperienceRequest;
import com.mario.pokeapi.soap.GetPokemonBaseExperienceResponse;
import com.mario.pokeapi.soap.GetPokemonHeldItemsRequest;
import com.mario.pokeapi.soap.GetPokemonHeldItemsResponse;
import com.mario.pokeapi.soap.GetPokemonIdRequest;
import com.mario.pokeapi.soap.GetPokemonIdResponse;
import com.mario.pokeapi.soap.GetPokemonLocationAreaEncountersRequest;
import com.mario.pokeapi.soap.GetPokemonLocationAreaEncountersResponse;
import com.mario.pokeapi.soap.GetPokemonNameRequest;
import com.mario.pokeapi.soap.GetPokemonNameResponse;
import com.mario.pokeapi.soap.GetPokemonRequest;
import com.mario.pokeapi.soap.GetPokemonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://www.mario.com/pokeapi/soap";

    @Autowired
    private PokemonService pokemonService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        return pokemonService.getPokemon(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonAbilitiesRequest")
    @ResponsePayload
    public GetPokemonAbilitiesResponse getPokemonAbilities(@RequestPayload GetPokemonAbilitiesRequest request) {
        return pokemonService.getPokemonAbilities(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonBaseExperienceResponse getPokemonBaseExperience(
            @RequestPayload GetPokemonBaseExperienceRequest request) {
        return pokemonService.getPokemonBaseExperience(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonHeldItemsRequest")
    @ResponsePayload
    public GetPokemonHeldItemsResponse getPokemonBaseExperience(@RequestPayload GetPokemonHeldItemsRequest request) {
        return pokemonService.getPokemonHeldItems(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonIdRequest")
    @ResponsePayload
    public GetPokemonIdResponse getPokemonBaseExperience(@RequestPayload GetPokemonIdRequest request) {
        return pokemonService.getPokemonId(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonNameRequest")
    @ResponsePayload
    public GetPokemonNameResponse getPokemonBaseExperience(@RequestPayload GetPokemonNameRequest request) {
        return pokemonService.getPokemonName(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonLocationAreaEncountersResponse getPokemonBaseExperience(
            @RequestPayload GetPokemonLocationAreaEncountersRequest request) {
        return pokemonService.getPokemonLocationAreaEncounters(request.getName());
    }
}
