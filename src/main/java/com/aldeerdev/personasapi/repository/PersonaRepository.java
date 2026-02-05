package com.aldeerdev.personasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aldeerdev.personasapi.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
