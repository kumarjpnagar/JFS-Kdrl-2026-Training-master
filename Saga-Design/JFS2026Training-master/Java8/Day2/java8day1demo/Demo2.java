package java8day1demo;

@FunctionalInterface
interface ICarFunctionality<T,V>{
	
	public T get(V name); //SAM
}

class Car{
	
//	public Car() {
//		System.out.println("No Arg Constructor!");
//	}
	
	//Constructor 
	public Car(String name) {
		System.out.println("One Arg Constructor!"+name);
		//return 
	}
}

public class Demo2 {

	public static void main(String[] args) {
		
		//ICarFunctionality<Car> obj = () -> {return new Car();}; 
		
		//ICarFunctionality<Car> obj = (name) -> {return new Car(name);};
		//Constructor Method Referencing
		
		ICarFunctionality<Car,String> obj = Car :: new; 
		
		System.out.println(obj.get("BMW"));

	}

}
