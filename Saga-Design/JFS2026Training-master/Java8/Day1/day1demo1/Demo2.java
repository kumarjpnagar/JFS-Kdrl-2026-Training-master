package day1demo1;

//@FunctionalInterface
interface IShare<T>{
	//public void displayShareDetails(String shareDetails); //SAM
	//without definitions
	//How many Abstract Method Should be there? 
	//Answer: Only One Abstract Method.
	public void displayShareDetails2(T shareDetails); 
	
	//with definitions
	public default int add(int a, int b) {
		return a+b;
	}
	
	//with definitions
	public static int sub(int a, int b) {
		return a-b;
	}
}
public class Demo2 {

	public static void main(String args[]) {
		//Anonymous Function
		//Type Inference
		//SIngle Parameter for the function then no need of
		//Paranthesis
		//The target type of this expression must be a functional interface
		IShare obj = details -> System.out.println(details);
		
		//Instance Method Referencing, Constructor Referencing , 
		//Arbitrary Instance Referencing , Static Method Referencing
		
		//IShare<String> obj = (details) -> System.out::println;
		
		obj.displayShareDetails2("This is GOGL Share Details");
	}
	
}
