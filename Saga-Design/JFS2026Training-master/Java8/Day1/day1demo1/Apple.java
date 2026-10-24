package day1demo1;

//POJO Class - Plain Old Java Object
public class Apple {
	
	//Instance Variable
	private int weight = 0;
    private String color = "";

    public Apple() {
		// TODO Auto-generated constructor stub
	}
    
    //Parameterized Constructor
    public Apple(int weight, String color) {
      this.weight = weight;
      this.color = color;
    }

    //read & write to the instance variable via getters & setters
    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    //Decorators , Annotations
    @SuppressWarnings("boxing")
    @Override
    public String toString() {
      return String.format("Apple{color='%s', weight=%d}", color, weight);
    }
}
