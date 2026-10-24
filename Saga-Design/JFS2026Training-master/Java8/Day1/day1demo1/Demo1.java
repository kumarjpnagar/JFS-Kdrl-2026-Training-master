package day1demo1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//1st approach is explicit class with name
class AppleComparison implements Comparator<Apple>{
	@Override
	public int compare(Apple ap1, Apple ap2) {
		// TODO Auto-generated method stub
		if(ap1.getWeight()==ap2.getWeight())
			return 0;
		else if(ap1.getWeight()>ap2.getWeight())
			return -1;
		else
			return 1;
	}
}

public class Demo1 {

	public static void main(String[] args) {
		
		//add(10,20){processing} //Lambda Calculus
		//Lambda's -> Lambda Expressions
		//Functions are treated as First-Class-Object
		//Declare and we Define and We Call function
		//Passing the functions an Arguments, Return them as a value
		// Assign functions to a variable
		// int a = 10; char c = 'Z'; String str = "Sabari"
		// add = (a,b) -> {return a+b} //Lambda Structure
		// Anonymous Class & Anonymous Function will contribute for
		// Representing the Lambda Syntax
		
		//Collections Topics are very essential
		
		List<Apple> listOfApples = new ArrayList<>();
		
		Apple a1 = new Apple(75,"Green");
		Apple a2 = new Apple(25,"Red");
		Apple a3 = new Apple(100,"Red");
		Apple a4 = new Apple(200,"Green");
		Apple a5 = new Apple(155,"Green");
		Apple a6 = new Apple(140,"Red");
		
		listOfApples.add(a1);
		listOfApples.add(a2);
		listOfApples.add(a3);
		listOfApples.add(a4);
		listOfApples.add(a5);
		listOfApples.add(a6);
		
		//One Example for Iteration
		
		//listOfApples.forEach((a)->System.out.println(a));
		//You can't use Method Referencing for Customization
		//listOfApples.forEach(System.out::println);
		listOfApples.forEach((a)->System.out.println(a.getWeight()));
		
//		for(Apple a : listOfApples) {
//			System.out.println(a);
//		}
		
		//Cannot instantiate the type Comparator<Apple> is an Interface
		//Anonymous Inner Class
		
//		Comparator<Apple> byWeight = new Comparator<Apple>() {
//		
//				@Override
//				public int compare(Apple a1, Apple a2) {
//					// TODO Auto-generated method stub
//					
//					if(a1.getWeight()==a2.getWeight())
//						return 0;
//					else if(a1.getWeight()>a2.getWeight())
//						return 1;
//					else
//						return -1;
//							
//				}
//		};
		
		
		//Anonymous Function -> Lambda Function (Lambda Expression)
		Comparator<Apple> byLambdaWeight = (ap1,ap2) -> {
			
			if(ap1.getWeight()==ap2.getWeight())
				return 0;
			else if(ap1.getWeight()>ap2.getWeight())
				return -1;
			else
				return 1;
		};
		
		Comparator<Apple> byLambdaColor = (ap1,ap2) -> {
			return ap1.getColor().compareTo(ap2.getColor());
		};
		
		//System.out.println(listOfApples);
		
		listOfApples.sort(byLambdaColor);
		
		//System.out.println("-------------After Sort--------------");
		//System.out.println(listOfApples);
		
		
		
		//Lambda Expression
		//Number of Lines of Code is reduced
		//Anonymous Function
		//Type Inferrence - Identifying what datat type it falls under
		//-> arrow token or lambda operator
		//Make the code shorter as possible
		//Anonymous inner class is replaced into a Lambda Expression
		//Comparator<Apple> byLambdaWeight = (a,b) -> a.getWeight().compareTo(b.getWeight());
//		Object
		//Rules:
			//1. Lambda Expression only for INterface Types
			//2. Interface should carry single Abstract method(SAM)
		
	
		

	}

}
