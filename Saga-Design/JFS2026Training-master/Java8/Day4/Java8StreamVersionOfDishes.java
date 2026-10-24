package com.day3demos.streams;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
public class Java8StreamVersionOfDishes {

	public static void main(String[] args) {
		
//				Dish.menu.stream()
//							//Sequential Streams
//				 .filter(d -> d.getCalories() < 500 ) //->Intermediate Operation
//				 .sorted(comparing(Dish::getCalories)) //->Intermediate Operation		//-> Create an Stream Instance
//				 .map(Dish::getName) //->Intermediate Operation //-> Converting into another form of Data
//				 //.collect(toList()); //Terminal Operation
//				 .forEach(System.out::println);
				 //.
				
		//Parallel Stream
				
		//To exploit a multicore architecture and execute this code in 
		//parallel, you need only to change stream() to parallelStream()		
				//Dish.menu.parallelStream();
				
				//Dish.menu.stream().parallel();
		
//		Mapping
//
//		A common data processing idiom is to select information 
//		from certain objects. For example, in SQL you can select a 
//		particular column from a table. The Streams API provides similar 
//		facilities through the map and flatMap methods.
		
//		List<String> lowCaloricDishesName =  Dish.menu.stream()
//				 .filter(d -> d.getCalories() < 500 ) //->Intermediate Operation
//				 .sorted(Comparator.comparing(Dish::getCalories)) //->Intermediate Operation		//-> Create an Stream Instance
//				 .map(Dish::getName) //->Intermediate Operation //-> Converting into another form of Data
//				 .collect(Collectors.toList()); //Terminal Operation
//		
//		System.out.println(lowCaloricDishesName);
		
		List<Dish> vegetarianDishes = Dish.menu.stream()
				.filter(Dish::isVegetarian)
				//.map()
				//.reduce() //Hadoop MapReduce feature
				.collect(toList());
		
		System.out.println(vegetarianDishes);
		
		//MapReduce Operation
		String dishNames = Dish.menu.stream()
		.map(dish -> dish.getName())
		.distinct()
		.sorted()
		.reduce("",(partialString,dn2)-> partialString + dn2);
		
		System.out.println(dishNames);
		
		Optional<Dish> dish =  Dish.menu.stream()
		.filter(Dish:: isVegetarian)
		.findAny(); //Method always Returns Optional object
		
		dish.ifPresent(dish2->System.out.println(dish2.getName()));
		
		  Dish.menu.stream()
				.filter(Dish:: isVegetarian)
				.findAny() //returns empty //Terminal Opertion
				.ifPresent(dish1 -> System.out.println(dish1.getName()));
		 //ifPresent vs isPresent of Optional
		  //if present method is no where belonging to the stream
		  //but it belongs to Optional
		
		
		//System.out.println(dish);
	}	
//""+"beef"+"Chicken"
}
