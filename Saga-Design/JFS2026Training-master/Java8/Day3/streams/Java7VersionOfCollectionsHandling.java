package com.day3demos.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java7VersionOfCollectionsHandling {

	public static void main(String args[]) {
		//1. Find out Low Caloried Dishes
		
		List<Dish> lowCaloricDishes  = new ArrayList<>();
		
		for(Dish d : Dish.menu) {
			if(d.getCalories()<500) { //Apply filter on the collection of objects
				lowCaloricDishes.add(d);
			}
		}
		
		//System.out.println(lowCaloricDishes);
		
		//2. Find The LowCaloricDishes and sort them based on calories
		
		List<Dish> lowCaloricDishesName  = new ArrayList<>();
		
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			};
		});
		
		for(Dish d: lowCaloricDishes) {
			lowCaloricDishesName.add(d);
		}
		
		System.out.println(lowCaloricDishesName);
		
	}
}
