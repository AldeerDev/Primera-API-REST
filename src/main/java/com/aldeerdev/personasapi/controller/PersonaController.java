package com.aldeerdev.personasapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aldeerdev.personasapi.model.Persona;
import com.aldeerdev.personasapi.service.PersonaService;

import jakarta.validation.Valid;

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
	public List<Persona> obtenerPersonas() {
		return personaService.obtenerPersonas();
	}
	
	@GetMapping("/personas/{id}")
	public Persona obtenerPersona(@PathVariable Long id) {
		return personaService.obtenerPersonaPorId(id);
	}
	
	@PostMapping("/personas")
	public Persona crearPersona(@Valid @RequestBody Persona persona) {
		return personaService.crearPersona(persona);
	}
}
