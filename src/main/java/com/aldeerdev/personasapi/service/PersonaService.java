package com.aldeerdev.personasapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aldeerdev.personasapi.model.Persona;

@Service
public class PersonaService {

	public List<Persona> obtenerPersonas() {
		return List.of(new Persona(1L, "Juan", 30), new Persona(2L, "Ana", 25),
				new Persona(3L, "Pedro", 40));
	}
}
