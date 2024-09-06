package com.example.holamundo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int tamano;
    private int tarjetas;

}
