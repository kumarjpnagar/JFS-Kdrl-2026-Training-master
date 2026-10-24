package com.rba.demo.exceptions;

public class RoomIDExistsException extends Exception {

	public RoomIDExistsException(String errorMessage) {
		super(errorMessage);
	}
}
