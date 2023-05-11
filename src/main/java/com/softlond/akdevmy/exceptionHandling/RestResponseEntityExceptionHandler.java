package com.softlond.akdevmy.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.softlond.akdevmy.responses.CustomResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<CustomResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		CustomResponse<Map<String, String>> response = new CustomResponse<>();
		
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		response.setMessage("El cuerpo de la petición no es válido");
		response.setData(errors);
	    return new ResponseEntity<CustomResponse<Map<String, String>>>(response, headers,HttpStatus.BAD_REQUEST);
	}
	
}
