package com.aldeerdev.personasapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeerdev.personasapi.model.Persona;
import com.aldeerdev.personasapi.service.PersonaService;

@RestController
public class PersonaController {
	
	private final PersonaService personaService;
	
	public PersonaController(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola Spring Boot!";
	}
	
	@GetMapping("/personas")
	public List<Persona> obtenerPersona() {
		return personaService.obtenerPersonas();
	}
}
