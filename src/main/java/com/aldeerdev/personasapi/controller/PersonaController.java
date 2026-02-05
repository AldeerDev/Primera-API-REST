package com.aldeerdev.personasapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeerdev.personasapi.model.Persona;

@RestController
public class PersonaController {
	
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola Spring Boot!";
	}
	
	@GetMapping("/personas")
	public List<Persona> obtenerPersona() {
		return List.of(
				new Persona(1L, "Juan", 30),
				new Persona(2L, "Ana", 25),
				new Persona(3L, "Pedro", 40));
	}
}
