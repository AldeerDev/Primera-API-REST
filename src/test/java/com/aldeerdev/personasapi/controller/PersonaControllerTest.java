package com.aldeerdev.personasapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.aldeerdev.personasapi.model.Persona;
import com.aldeerdev.personasapi.service.PersonaService;

@WebMvcTest(PersonaController.class)
public class PersonaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonaService personaService;

	@Test
	void debeRetornarListDePersonas() throws Exception {
		when(personaService.obtenerPersonas()).thenReturn(List.of(new Persona("Juan", 30)));
		mockMvc.perform(get("/personas")).andExpect(status().isOk()).andExpect(jsonPath("$[0].nombre").value("Juan"));
	}
}
