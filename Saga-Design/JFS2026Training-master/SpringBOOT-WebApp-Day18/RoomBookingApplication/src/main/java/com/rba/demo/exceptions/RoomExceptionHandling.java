package com.rba.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
//ControllerAdvice
public class RoomExceptionHandling {

	@ExceptionHandler(value = {Exception.class})
	//@ResponseBody
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		
		//request.getParameter("")
		
		String errorMessageDescription = ex.getLocalizedMessage();
		System.out.println(errorMessageDescription);
		
		
		//If some exception object does'nt carry the localozed messgae
		// then this if block get executed
		if(errorMessageDescription == null) {
			errorMessageDescription = ex.toString();
		}
		
		
		Error error = new Error(new Date(),errorMessageDescription);
		
		
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(
				error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR
				);
				
		return responseEntity;
	}
	
	
}
