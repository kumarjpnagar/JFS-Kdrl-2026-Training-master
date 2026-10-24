package com.java11demos;

import java.util.function.BiConsumer;

public class Demo2 {

	int x = 10; //Class Level or Instance Variable
	static int y = 30; //Static varaible
	public void disp() {
		//Local Variable Syntax
		//RHS Value
		final var x = "Sabari"; //Local variable to that method alone
		var age = 24;
		System.out.println(x);
		//ORM Hibernate
		//@Nullable -> Annotation
		BiConsumer<String, String> biobj = (var s1,  var s2)-> System.out.println(s1+s2);
		
		biobj.accept("Sabari", "Balaji");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo2().disp();

	}

}
