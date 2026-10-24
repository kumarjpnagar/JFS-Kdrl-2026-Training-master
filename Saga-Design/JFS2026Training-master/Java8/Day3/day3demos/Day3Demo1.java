package com.day3demos;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

//Package java.util.function
//
//this package will carry 43 interfaces and all 43 interfaces are 
//Functional Interface -> SAM, but few interfaces might carry static and default methods.
//
//All 43 interfaces are General Purpose Interface
//
//The interfaces in this package are general purpose functional interfaces used by the JDK, and are available to be used by user code as well. 
//
//While they do not identify a complete set of function shapes to which lambda expressions might be adapted, they provide enough to cover common requirements. 
//
//Specific Purpose Functional Interfaces
//
//Comparator java.util
//FileFilter -> Files Concepts java.io
//
//1. Predicate
//2. Consumer
//3. Function
//4. Syupplier
//

//new package called function introduced in Java 1.8 version onwards
//function package contains 43 functional interfaces
class Employee{
	public Employee() {
		System.out.println("Employee Instance");
	}

	@Override
	public String toString() {
		return "Employee []";
	}
	
	
}
public class Day3Demo1 {

	public static void main(String a[]) {
		//Consumer<String> cobj = name -> System.out.println(name);
		
		Consumer<Boolean> cobj1 = System.out::println;
		
		Consumer<Boolean> cobj2 = System.out::println;
		
		Consumer<Boolean> cobj3 = cobj1.andThen(cobj2);
		
		cobj3.accept(true);
//		cobj.accept(true);
		
		//Supplier<String> sobj = String::new;
		
		//Supplier<Employee> sobj = Employee::new;
		
//		Supplier<Employee> sobj = () -> {
//			Employee e = new Employee();
//			return e;
//		};
//		
//		Function<Integer, String> fobj = eid -> eid == 101 ? "Sabari":"Balaji";
//		
////		System.out.println(sobj.get());
//		
//		String result = fobj.apply(101);
//		System.out.println(result);
//		
//		Predicate<Integer> pobj = eid -> eid == 101 ? true:false;
//		
//		System.out.println(pobj.test(102));
//		
//		List<String> fruits = new ArrayList<>();
//		
//		fruits.add("Apple");
//		fruits.add("Banana");
//		fruits.add("Promogenate");
//		fruits.add("Pears");
//		fruits.add("Grapes");
//		
//		//fruits.forEach((name)-> System.out.println(name));
//		
//		fruits.forEach(System.out::println);
//		
//		//IntPredicate
//		//IntConsumer
//		//IntFunction<R>
//		//IntSupplier
//		
//		Dou
 	}
}
