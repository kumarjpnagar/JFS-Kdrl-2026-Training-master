package java8day1demo;

interface i1{
	public void disp1();
	
	public default void disp2() {
		System.out.println("Interface1 disp2");
		//15 line code
	}
	
}

interface i2{

	public default void disp2() {
		System.out.println("Interface2 disp2");
		//15 lines of code
	}
}
//Duplicate default methods named disp2 with the parameters () and () are inherited from the types i2 and i1
class X implements i1,i2{
	@Override
	public void disp1() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void disp2() {
		// TODO Auto-generated method stub
		i1.super.disp2(); //15lines reused
		i2.super.disp2(); //15line reused
	}
}

class Y implements i1,i2{
	@Override
	public void disp1() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void disp2() {
		// TODO Auto-generated method stub
		i1.super.disp2();
		i2.super.disp2();
	}
}
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		X obj1 = new X();
		
		Y obj2 = new Y();
		
		obj1.disp2();
		obj2.disp2();
		

	}

}
