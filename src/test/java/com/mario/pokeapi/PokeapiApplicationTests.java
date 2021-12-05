package com.mario.pokeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mario.pokeapi.models.PokemonRest;
import com.mario.pokeapi.repositories.PokemonRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class PokeapiApplicationTests {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Test
	void testRestApiId() {
		ResponseEntity<PokemonRest> response=pokemonRepository.findPokemon("1");

		assertNotNull(response.getBody());
		assertEquals("bulbasaur",response.getBody().getName());
	}

	@Test
	void testRestApiName() {
		ResponseEntity<PokemonRest> responseName=pokemonRepository.findPokemon("bulbasaur");

		assertNotNull(responseName.getBody());
		assertEquals("bulbasaur",responseName.getBody().getName());
	}

	@Test
	void testRestApiBadId() {
		ResponseEntity<PokemonRest> responseNull=pokemonRepository.findPokemon("-1");

		assertNull(responseNull.getBody());
	}

	@Test
	void testRestApiBadName() {
		ResponseEntity<PokemonRest> responseNameNull=pokemonRepository.findPokemon("badname");

		assertNull(responseNameNull.getBody());
	}

	@Test
	void testRestApiStringName() {
		String responseString=pokemonRepository.findPokemonString("1");

		assertNotNull(responseString);
		assertTrue(responseString.contains("bulbasaur"));
	}

	@Test
	void testRestApiStringHeldItemEmpty() {
		String responseString=pokemonRepository.findPokemonString("1");

		assertNotNull(responseString);
		assertTrue(responseString.contains("held_items=[],"));
	}

}
