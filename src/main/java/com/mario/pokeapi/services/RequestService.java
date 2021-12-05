package com.mario.pokeapi.services;

import java.util.List;

import com.mario.pokeapi.entities.Request;

public interface RequestService {

    List<Request> getAllRequest();

    Request getRequestById(Long id);

    void save(Request request);

}
