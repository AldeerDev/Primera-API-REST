package com.aldeerdev.personasapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aldeerdev.personasapi.exception.PersonaNotFoundException;
import com.aldeerdev.personasapi.model.Persona;

@Service
public class PersonaService {

	private final List<Persona> personas = new ArrayList<Persona>();
	
	public PersonaService() {
		personas.add(new Persona(1L, "Juan", 30));
		personas.add(new Persona(2L, "Ana", 25));
		personas.add(new Persona(3L, "Pedro", 40));
	}

	public List<Persona> obtenerPersonas() {
		return personas;
	}
	
	public Persona obtenerPersonaPorId(Long id) {
		return personas.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new PersonaNotFoundException(id));
	}
	
	public Persona crearPersona(Persona persona) {
		personas.add(persona);
		return persona;
	}
}
