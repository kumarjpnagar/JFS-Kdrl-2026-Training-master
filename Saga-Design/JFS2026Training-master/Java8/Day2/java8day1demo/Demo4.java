package java8day1demo;

//Why Java Community have decided to bring Default Methods and
//Static Methods in interfaces from Java 8?

//Bose Vendor is offering a contract via Interfaces
//By adding a New Feature in Bose Contract
interface BoseAudioPlayer{
	public void manualAudioDashboard(); //AM //175$
	
	public void manualFMAddon(); //AM //150$
	
	//Abstract methods do not specify a body
	public default void  flightMode() { //AM //200$ //free feature
		//empty definition
		//15 lines logic code
		
		BoseAudioPlayer.helperMethod();
	}
	
	//both static and default methods can have definitions
	//Utility Methods
	public static void helperMethod() {
		//20 lines -> database -> pulls the data-> prepares list of objects
	}
}

//Ford Client is going to tether with Bose Vendor
//Will impact the existing system for FORD
//Backward Compatibility 
class Ford implements BoseAudioPlayer{
	
	@Override
	public void manualAudioDashboard() {
		// TODO Auto-generated method stub
		//BoseAudioPlayer.helperMethod();
		
	}
	
	@Override
	public void manualFMAddon() {
		// TODO Auto-generated method stub
		
	}
}

class BMW implements BoseAudioPlayer {
	@Override
	public void manualAudioDashboard() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void manualFMAddon() {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void flightMode() {
//		// TODO Auto-generated method stub
//		
//	}
}

class Thar implements BoseAudioPlayer{
	
	@Override
	public void manualAudioDashboard() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void manualFMAddon() {
		// TODO Auto-generated method stub
		
	}
}	

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ford f1 = new Ford();
		
		f1.flightMode();

		f1.manualAudioDashboard();
		
		f1.manualFMAddon();
		
		//f1.helperMethod();
		
		//BoseAudioPlayer.helperMethod();
	}

}
