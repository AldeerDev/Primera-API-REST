package com.aldeerdev.personasapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Persona> obtenerPersona(@PathVariable Long id) {
		Persona persona = personaService.obtenerPersonaPorId(id);
		return ResponseEntity.ok(persona);
	}

	@PostMapping("/personas")
	public ResponseEntity<Persona> crearPersona(@Valid @RequestBody Persona persona) {
		Persona creada = personaService.crearPersona(persona);
		return ResponseEntity.status(201).body(creada);
	}

	@PutMapping("/personas/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @Valid @RequestBody Persona persona) {
		Persona actualizada = personaService.actualizarPersona(id, persona);
		return ResponseEntity.ok(actualizada);
	}
}
