package com.aldeerdev.personasapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aldeerdev.personasapi.dto.PersonaRequestDTO;
import com.aldeerdev.personasapi.exception.PersonaNotFoundException;
import com.aldeerdev.personasapi.model.Persona;
import com.aldeerdev.personasapi.repository.PersonaRepository;

@Service
public class PersonaService {

	private final PersonaRepository repository;

	public PersonaService(PersonaRepository repository) {
		this.repository = repository;
	}

	public List<Persona> obtenerPersonas() {
		return repository.findAll();
	}

	public Persona obtenerPersonaPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new PersonaNotFoundException(id));
	}

	public Persona crearPersona(PersonaRequestDTO dto) {
		Persona persona = new Persona();
		persona.setNombre(dto.getNombre());
		persona.setEdad(dto.getEdad());
		return repository.save(persona);
	}

	public Persona actualizarPersona(Long id, Persona personaActualizada) {
		Persona persona = obtenerPersonaPorId(id);
		persona.setNombre(personaActualizada.getNombre());
		persona.setEdad(personaActualizada.getEdad());
		return persona;
	}

	public void eliminarPersona(Long id) {
		repository.deleteById(id);
	}
}
