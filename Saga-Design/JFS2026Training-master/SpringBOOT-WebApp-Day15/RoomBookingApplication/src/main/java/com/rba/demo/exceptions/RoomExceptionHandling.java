package com.rba.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//ControllerAdvice
public class RoomExceptionHandling {

	@ExceptionHandler(value = {ArithmeticException.class})
	//@ResponseBody
	public String handleAnyException2(Exception ex) {
		
		return "This is an Arithmetic Error: "+ex.getMessage();
	}
}
