package interface_lab;
import java.util.function.Function;
//import java.util.Scanner;
public class Interface_Lab {
    public static void main(String[] args) {
    int centigrade = 100;
    Function<Integer,Double> centigradeToFahrenheitInt = x -> new Double((x*9/5)+32);
    Function<String, Integer> stringToInt = x -> Integer.valueOf(x);
    System.out.println("Centigrade to Fahrenheit: "+centigradeToFahrenheitInt.apply(centigrade));
    System.out.println("String to Int: " + stringToInt.apply("4"));    
    }
    @FunctionalInterface
    public interface Function<T, R> {
    R apply(int t);
	}
Function<Integer,Double> functionSqrt = n -> Math.sqrt(n);
            System.out.println("Square root of 49: "+functionSqrt.apply(49));
            System.out.println("Square root of 68: "+functionSqrt.apply(68));


double secondRoot = 0, firstRoot = 0;
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the value of a ::");
      double a = sc.nextDouble();

      System.out.println("Enter the value of b ::");
      double b = sc.nextDouble();

      System.out.println("Enter the value of c ::");
      double c = sc.nextDouble();

      double determinant = (b*b)-(4*a*c);
      double sqrt = Math.sqrt(determinant);

      if(determinant>0){
         firstRoot = (-b + sqrt)/(2*a);
         secondRoot = (-b - sqrt)/(2*a);
         System.out.println("Roots are :: "+ firstRoot +" and "+secondRoot);
      }else if(determinant == 0){
         System.out.println("Root is :: "+(-b + sqrt)/(2*a));
      }
    
	}
}