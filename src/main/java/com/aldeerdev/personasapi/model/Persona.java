package com.aldeerdev.personasapi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Persona {

	private Long id;
	
	@NotBlank
	private String nombre;
	
	@Min(0)
	private int edad;

	public Persona(Long id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

}
