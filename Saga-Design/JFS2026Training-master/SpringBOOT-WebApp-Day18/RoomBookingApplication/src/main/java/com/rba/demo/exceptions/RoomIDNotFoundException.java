package com.rba.demo.exceptions;

//This is how we create an Custom Exception in Java
public class RoomIDNotFoundException extends Exception {

	public RoomIDNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
