package com.aldeerdev.personasapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
	
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola Spring Boot!";
	}
}
