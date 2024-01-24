package com.example.rest.web.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Void> handleDataAccessException(DataAccessException cause) {
		log.error(cause.getMessage(), cause);
		
		return ResponseEntity.internalServerError().build();
	}
}
