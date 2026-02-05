package com.aldeerdev.personasapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PersonaNotFoundException.class)
	public String handlerPersonaNotFound(PersonaNotFoundException ex) {
		return ex.getMessage();
	}
}
