public class  Shape{
	abstract public void drow();
}

public class Rectangle extends Shape{
	void drow(){
		System.out.println("drow Rectangle");
	}
}

public class Circle extends Shape{
		void drow(){
		System.out.println("drow Circle");
	}
}
public class Method{

  public static void Test(list <? extends Shape>  listshap) {
	  for(Shape s:listshap){
		  listshap.drow();
	  }
	
  }
}

  
  
  public class Generic {

  public static void main(String[] args) {
	  list<Rectangle> sh1 = new ArrayList<Rectangle>();
	  sh1.add(new Rectangle());
	    list<Circle> sh2 = new ArrayList<Circle>();
	  sh2.add(new Circle());
	  Method.drow(sh1);
	   Method.drow(sh2);
  }
  }