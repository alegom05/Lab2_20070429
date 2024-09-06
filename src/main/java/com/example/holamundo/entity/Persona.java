package com.example.holamundo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private String codigoPUCP;
    private String direccion;

    public Persona(String nombre, String apellido, String dni, int codigoPUCP, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.codigoPUCP = String.valueOf(codigoPUCP);
        this.direccion = direccion;

    }
}
