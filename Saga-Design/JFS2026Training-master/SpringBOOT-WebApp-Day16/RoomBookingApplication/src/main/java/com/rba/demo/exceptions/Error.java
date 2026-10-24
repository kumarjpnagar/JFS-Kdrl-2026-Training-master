package com.rba.demo.exceptions;

import java.util.Date;

public class Error {

	private Date timeStamp;
	private String errorMessage;
	
	public Error() {
		// TODO Auto-generated constructor stub
	}

	public Error(Date timeStamp, String errorMessage) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
