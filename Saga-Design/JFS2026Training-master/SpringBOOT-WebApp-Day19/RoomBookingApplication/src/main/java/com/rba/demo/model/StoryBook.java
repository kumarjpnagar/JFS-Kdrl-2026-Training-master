package com.rba.demo.model;

public class StoryBook implements Book {

	String name;
	public StoryBook(String name) {
		this.name=name;
	}

	@Override
	public void printBookName() {
		System.out.println(this.name);
		
	}

}

