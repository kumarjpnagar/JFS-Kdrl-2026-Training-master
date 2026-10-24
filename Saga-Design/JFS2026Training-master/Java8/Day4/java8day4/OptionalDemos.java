package com.java8day4;

import java.util.Optional;

public class OptionalDemos {

	public static void main(String[] args) {
		
		//When you are operating on top of streams
		//the stream intermediate functions will produce the streams
		//terminal operation will act on the final stream
		
		String name = "Sabari";
		
		//Optional<String> opt = Optional.of(name);
		//will return empty if the variable is null
		//else it will the return then actual value
		Optional<String> opt = Optional.ofNullable(name);
		
		//System.out.println(opt.get());
		
		String result = Optional.ofNullable(name).orElse("John");
		System.out.println(result);
		//System.out.println(opt);
		
		//System.out.println(opt.isPresent());
		//System.out.println(opt.isEmpty());
		//== null
//		if(opt.isPresent()) {
//			System.out.println(opt.get());
//		}
	}

}
