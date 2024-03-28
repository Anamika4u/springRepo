package com.crudoperationwithexceptionhandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

	@Value(value="${data.exception.msg}")
	private String msg;
	@Value(value="${data.exception.msg1}")
	private String msg1;
	@ExceptionHandler(value = StudentAlreadyExistsException.class)
	public ResponseEntity<String> handleStudentAlreadyExistsException(StudentAlreadyExistsException ex){
		return new ResponseEntity<>(msg, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex){
		return new ResponseEntity<>(msg1, HttpStatus.NOT_FOUND);
	}
}
