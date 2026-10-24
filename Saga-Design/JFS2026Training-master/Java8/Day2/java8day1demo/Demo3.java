package java8day1demo;

import java.util.Arrays;
import java.util.Comparator;

public class Demo3 {

	public static void main(String[] args) {
		
		String[] stringArray = {"sabari","balaji","Parthasarathy","Sundar","Albert","Joseph","Muhammed"};
		
		//Arbitrary Method Referencing
		//Comparator<String> namecomp = (a,b)-> a.compareToIgnoreCase(b);
		//Static Method Referencing
		Comparator<String> namecomp = String :: compareToIgnoreCase;
		Arrays.sort(stringArray,namecomp);
		
		for(String name : stringArray)
			System.out.println(name);
		
		

	}
	
	

}
