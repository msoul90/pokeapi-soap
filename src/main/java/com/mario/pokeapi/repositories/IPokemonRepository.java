package com.mario.pokeapi.repositories;

import java.util.Arrays;

import com.mario.pokeapi.models.PokemonRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class IPokemonRepository implements PokemonRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<PokemonRest> findPokemon(String name) {
        log.info("Consultando:{}", name);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<PokemonRest> response;

        try {
            response = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + name, HttpMethod.GET, entity,
                    PokemonRest.class);
        } catch (final HttpClientErrorException e) {
            log.error(e.getStatusCode());
            log.error(e.getResponseBodyAsString());
            return ResponseEntity.badRequest().body(null);
        }
        return response;
    }

    @Override
    public String findPokemonString(String name) {
        log.info("Consultando:{}", name);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Object> response;

        try {
            response = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + name, HttpMethod.GET, entity,
                    Object.class);
        } catch (final HttpClientErrorException e) {
            log.error(e.getStatusCode());
            log.error(e.getResponseBodyAsString());

            return null;
        }

        return response.getBody() != null ? response.getBody().toString() : null;
    }

}
