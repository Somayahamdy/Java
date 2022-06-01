import java.util.ArrayList;
abstract class  Shape{
	abstract public void drow();
}

 class Rectangle extends Shape{
	 public void drow(){
		System.out.println("drow Rectangle");
	}
}
 class Circle extends Shape{
	public	void drow(){
		System.out.println("drow Circle");
	}
}
 class Method{

  public static void Test(ArrayList <? extends Shape>  listshap) {
	  for(Shape s:listshap){
		  s.drow();
	  }
	
  }
}

  
  
public  class Generic1 {

  public static void main(String[] args) {
	  ArrayList<Shape> sh1 = new ArrayList<Shape>();
	  sh1.add(new Rectangle());
	  sh1.add(new Circle());
	  Method.Test(sh1);
	  // Method.Test(sh2);
  }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  