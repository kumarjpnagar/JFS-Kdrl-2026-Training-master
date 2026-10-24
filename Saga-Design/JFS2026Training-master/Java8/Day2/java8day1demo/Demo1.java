package java8day1demo;

@FunctionalInterface
interface IEmail{
	//Abstract Method
	public abstract String getEmail(String name, String domain,String extension);//SAM
}

//class Sabari implements IEmail{
//	@Override
//	public String getEmail(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
public class Demo1 {

	//Instance Method
	//Class Method
	public static String manipulateEmailAddress(String name , String domain) {
		
		return name + "@"+domain+".com";
	}
	
	public static String manipulateEmailAddress(String name , String domain,String extension) {
		
		return name + "@"+domain+"."+extension;
	}
	
	public static void main(String[] args) {
		
		//Instance Method Referencing
		//Anonymous Inner Class Representation
		/*IEmail iEmailObj = new IEmail() {
			
			@Override
			public String getEmail(String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};*/
		
		//obj instance of the Demo1 class
		//Demo1 obj = new Demo1();
		
		//Lambda Expression
		//IEmail iEmailObj = (String name) ->  obj.manipulateEmailAddress(name);
		//IEmail iEmailObj = (String name,String domain) ->  obj.manipulateEmailAddress(name,domain);
		//Method Referencing Syntax
		
		//Lambda Expression + Instance Method Referencing Operation
		
		//IEmail iEmailObj = obj :: manipulateEmailAddress;
		
		//IEmail iEmailObj = (name,domain) ->  Demo1.manipulateEmailAddress(name,domain);
		
		//Static Method Referencing Call
		
		IEmail iEmailObj = Demo1 :: manipulateEmailAddress;
		
		String result  = iEmailObj.getEmail("sp00340556","msn","edu");
		
		System.out.println(result);
	

	}

}

//class Child extends Demo1{
//	
//	
//}
