package com.example.holamundo.controllers;

import com.example.holamundo.entity.Juego;
import com.example.holamundo.entity.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Controller
@RequestMapping("/")
public class TareaController {

    private int[][] matriz; // Atributo para almacenar la matriz generada


    @GetMapping(value = { "/",""})
    public String home(Model model, Juego juego) {
        model.addAttribute("msg", "¡Este es otro mensaje!");
        model.addAttribute("nombre", "Capibara");
        model.addAttribute("cantidad", 20);
        model.addAttribute("tamano", juego.getTamano());
        return "home";
    }

    @PostMapping(value = { "/",""})
    public String guardarValores( Model model, Persona persona, Juego juego){
        System.out.println("Tamaño: " + juego.getTamano() + "\n" +
                "Tarjetas: " + juego.getTarjetas() + "\n" +
                "Dni: " + persona.getDni() + "\n" +
                "CodigoPUCP: " + persona.getDni() + "\n" +
                "Direccion: " + persona.getDni());
        // Generar matriz con el tamaño especificado
        // Añadir la matriz al modelo

        // Add the matrix and size to the model
        model.addAttribute("tamano", juego.getTamano());
        model.addAttribute("tarjetas", juego.getTarjetas());

        return "formulario";
    }

    @GetMapping("/registrar")
    public String mostrarMatrices(Model model, Juego juego){
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Alejandro", "Gomez", "12345678", 20170101, "San Borja"));
        listaPersonas.add(new Persona("Mauricio", "Gomez", "85695489", 20213435,"San Miguel"));
        listaPersonas.add(new Persona("Barbara", "Bellido", "75856985", 20090234,"San Isidro"));
        model.addAttribute("listaPersonas", listaPersonas);

        int[][] matriz = generarMatriz(juego.getTamano());
        model.addAttribute("tarjetas", juego.getTarjetas());
        model.addAttribute("matriz", matriz);

        return "formulario";
    }

    @PostMapping(value = { "/registrar","/registrar/"})
    public String agregarNumero( Persona persona, Juego juego){
        System.out.println("Tamaño: " + juego.getTamano() + "\n" +
                "Tarjetas: " + juego.getTarjetas() + "\n" +
                "Dni: " + persona.getDni() + "\n" +
                "CodigoPUCP: " + persona.getDni() + "\n" +
                "Direccion: " + persona.getDni());
        return "formulario";
    }



    public int[][] generarMatriz(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(9); // Genera números aleatorios entre 0 y 99
            }
        }
        return matrix;
    }


}
