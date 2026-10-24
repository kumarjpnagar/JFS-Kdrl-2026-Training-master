package com.day3demos.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
public class Java8StreamsDemo2 {

	public static void main(String[] args) {

		List<Dish> specialMenu = Arrays.asList(new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER));

		// System.out.println(specialMenu);

		List<Dish> filteredMenu = specialMenu.stream()
				.filter(dish -> dish.getCalories() < 320)
				.collect(toList());
		
		System.out.println(filteredMenu);
		
		List<Dish> filteredMenu2 = specialMenu.stream()
				.takeWhile(dish -> dish.getCalories() < 320)
				.collect(toList());
		System.out.println(filteredMenu2);
		
		List<Dish> filteredMenu3 = specialMenu.stream()
				.dropWhile(dish -> dish.getCalories() < 320)
				.collect(toList());
		System.out.println(filteredMenu3);
		
		//Streams support the limit(n) method, which returns another stream 
		//that’s no longer than a given size.
		
		List<Dish> filteredMenu4 = specialMenu.stream()
				.filter(dish -> dish.getCalories() > 200)
				.limit(3)
				.collect(toList());
		System.out.println(filteredMenu4);
		
	}
	

}
