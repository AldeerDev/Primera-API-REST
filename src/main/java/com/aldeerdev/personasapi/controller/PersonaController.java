package com.aldeerdev.personasapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeerdev.personasapi.model.Persona;

@RestController
public class PersonaController {
	
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola Spring Boot!";
	}
	
	@GetMapping("/persona")
	public Persona obtenerPersona() {
		return new Persona(1L, "Juan", 30);
	}
}
