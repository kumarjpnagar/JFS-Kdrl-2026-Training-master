package com.java11demos;

import java.util.stream.Collectors;

public class Demo1 {

	public static void main(String[] args) {
		
//		String name1 = "Sabari";
//		System.out.println(name1.isBlank());
//		
//		String name2 = " ";
//		System.out.println(name2.isBlank());
//		
//		String name3 = "";
//		System.out.println(name3.isBlank());
		
		String str = "JD\nJD\nJD"; // /n refers to new line 
        System.out.println(str);
        
        System.out.println(str.lines().collect(Collectors.toList()));
        
        String str2 = "Ba".repeat(3);
        System.out.println(str2+"Black Sheep!");
		
		

	}

}
