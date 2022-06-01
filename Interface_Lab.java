//package interface_lab;
import java.util.function.Function;
//import java.util.Scanner;
public class Interface_Lab {
    public static void main(String[] args) {
    //int centigrade = 100;
    Function<Integer,Double> centigradeToFahrenheitInt = x -> new Double((x*9/5)+32);
    double fehren = centigradeToFahrenheitInt.apply(100);
	//Function<String, Integer> stringToInt = x -> Integer.valueOf(x);
    System.out.println("Centigrade to Fahrenheit: "+fehren);
   // System.out.println("String to Int: " + stringToInt.apply("4"));    
    }
    /*@FunctionalInterface
    public interface Function<T, R> {
    R apply(int t);
	}*/
}
