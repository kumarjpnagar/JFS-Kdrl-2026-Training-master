package com.rba.demo.model;

public class FictionBook implements Book {

	String name;
	
	public FictionBook(String name) {
		this.name = name;
	}
	
	@Override
	public void printBookName() {
		System.out.println(this.name);
		
	}
}

