package com.aldeerdev.personasapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aldeerdev.personasapi.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	Page<Persona> findAll(Pageable pageable);
}
