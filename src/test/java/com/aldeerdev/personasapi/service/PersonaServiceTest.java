package com.aldeerdev.personasapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.aldeerdev.personasapi.exception.PersonaNotFoundException;
import com.aldeerdev.personasapi.model.Persona;
import com.aldeerdev.personasapi.repository.PersonaRepository;

public class PersonaServiceTest {

	private final PersonaRepository repository = mock(PersonaRepository.class);
	private final PersonaService service = new PersonaService(repository);

	@Test
	void debeRetornarPersonaPorId() {
		Persona persona = new Persona("juan", 30);

		when(repository.findById(1L)).thenReturn(Optional.of(persona));

		Persona resultado = service.obtenerPersonaPorId(1L);
		assertEquals("Juan", resultado.getNombre());

		verify(repository).findById(1L);
	}

	@Test
	void debeLanzarExcepcionSiNoExiste() {
		when(repository.findById(99L)).thenReturn(Optional.empty());

		assertThrows(PersonaNotFoundException.class, () -> service.obtenerPersonaPorId(99L));
	}
}
