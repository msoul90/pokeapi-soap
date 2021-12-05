package com.mario.pokeapi.services;

import java.util.List;

import com.mario.pokeapi.entities.Request;
import com.mario.pokeapi.repositories.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class IRequestService implements RequestService {

    @Autowired
    private RequestRepository repository;

    @Override
    public List<Request> getAllRequest() {
        return repository.findAll();
    }

    @Override
    public Request getRequestById(Long id) {
        if (id == null || id < 1) {
            log.error("ID no valido");
            return null;
        }
        return repository.getById(id);
    }

    @Override
    public void save(Request request) {
        repository.save(request);
    }

}
