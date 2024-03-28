package com.restapimongodb;
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
	    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
	    public ResponseEntity<String> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex){
	        return new ResponseEntity<>(msg, HttpStatus.CONFLICT);
	    }

	    @ExceptionHandler(value = EmployeeNotFoundException.class)
	    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
	        return new ResponseEntity<>(msg1, HttpStatus.NOT_FOUND);
	    }

}
