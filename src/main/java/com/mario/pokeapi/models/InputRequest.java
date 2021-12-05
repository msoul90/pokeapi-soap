package com.mario.pokeapi.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputRequest {
    private String ip;
    private LocalDate fecha;
    private String metodo;
}
