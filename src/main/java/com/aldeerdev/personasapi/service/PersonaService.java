package com.aldeerdev.personasapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aldeerdev.personasapi.dto.PersonaRequestDTO;
import com.aldeerdev.personasapi.exception.PersonaNotFoundException;
import com.aldeerdev.personasapi.model.Persona;
import com.aldeerdev.personasapi.repository.PersonaRepository;

@Service
public class PersonaService {
	
	private static final Logger log = LoggerFactory.getLogger(PersonaService.class);

	private final PersonaRepository repository;

	public PersonaService(PersonaRepository repository) {
		this.repository = repository;
	}

	public Page<Persona> obtenerPersonas(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Persona obtenerPersonaPorId(Long id) {
		log.info("Buscando Persona con id {}", id);
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
