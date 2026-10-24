package com.java8day4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Reduce -> stream of data into an single result
		
		List<String> letters = Arrays.asList("a","b","c","d","e");
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		System.out.println(letters);
		
		String result = letters.stream()
		.reduce("@",(s1,elements)-> s1+elements);
		
		System.out.println(result);
		
		int result1 = numbers.stream()
				.reduce(0,(s1,elements)-> s1+elements);
		
		System.out.println(result1);
		
		
		
	}

}
