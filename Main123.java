//import java.lang.String;
import java.util.function.BiPredicate;

	
 public class Main123{
	 	public static void main(String args[]){
		String s1 = new String ("somaya");
		String s2 = new String ("mohammed");
		
	//String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
   // String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
     System.out.println	("the String is "+betterString(s1,s2,(x,y) -> x.length() > y.length()));
	}
	 static String betterString(String s1,String s2,BiPredicate<String,String> isbetter){
		 if(isbetter.test(s1,s2)){
			 return s1;
		 }
		 else{
			 return s2;
		 }
	 }
 
	
 }
