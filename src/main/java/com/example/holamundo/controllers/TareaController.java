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
@RequestMapping("/patito_hule")
public class TareaController {

    private int[][] matriz; // Atributo para almacenar la matriz generada

    //Configuración
    @GetMapping(value = { "/",""})
    public String home(Model model, Juego juego) {
        model.addAttribute("filas", juego.getFilas());
        model.addAttribute("columnas", juego.getColumnas());
        model.addAttribute("posiciones", juego.getPosiciones());
        model.addAttribute("fotos", juego.getFotos());
        return "home";
    }

    @PostMapping(value = { "/",""})
    public String guardarValores( Model model, Persona persona, Juego juego){
        //Validaciones
        System.out.println("Tamaño: " + juego.getFilas() + "\n" +
                "Tarjetas: " + juego.getColumnas() + "\n" +
                "Dni: " + persona.getDni() + "\n" +
                "CodigoPUCP: " + persona.getDni() + "\n" +
                "Direccion: " + persona.getDni());
        // Generar matriz con el tamaño especificado
        model.addAttribute("filas", juego.getFilas());
        model.addAttribute("columnas", juego.getColumnas());
        model.addAttribute("posiciones", juego.getPosiciones());
        model.addAttribute("fotos", juego.getFotos());
        // Añadir la matriz al modelo


        return "formulario";
    }

    //Fotos de patos
    @GetMapping("/registrar")
    public String mostrarMatrices(Model model, Juego juego){
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        //Pruebas
        listaPersonas.add(new Persona("Alejandro", "Gomez", "12345678", 20170101, "San Borja"));
        listaPersonas.add(new Persona("Mauricio", "Gomez", "85695489", 20213435,"San Miguel"));
        listaPersonas.add(new Persona("Barbara", "Bellido", "75856985", 20090234,"San Isidro"));
        model.addAttribute("listaPersonas", listaPersonas);
        //Matriz
        int[][] matriz = generarMatriz(juego.getFilas(), juego.getColumnas());
        model.addAttribute("filas", juego.getFilas());
        model.addAttribute("columnas", juego.getColumnas());
        model.addAttribute("posiciones", juego.getPosiciones());
        model.addAttribute("fotos", juego.getFotos());
        model.addAttribute("matriz", matriz);
        return "formulario";
    }

    //No es necesaria
    @PostMapping(value = { "/registrar","/registrar/"})
    public String agregarNumero( Persona persona, Juego juego){
        System.out.println("Tamaño: " + juego.getFilas() + "\n" +
                "Tarjetas: " + juego.getColumnas() + "\n" +
                "Dni: " + persona.getDni() + "\n" +
                "CodigoPUCP: " + persona.getDni() + "\n" +
                "Direccion: " + persona.getDni());
        return "formulario";
    }

    //Método para generar matriz
    public int[][] generarMatriz(int m, int n) {
        int[][] matrix = new int[m][n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0; // Genera números aleatorios entre 0 y 99
            }
        }
        return matrix;
    }


}
