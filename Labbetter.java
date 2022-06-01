import java.lang.String;
import java.util.function.Bipredicate;
//interface lambds{
//	abstract void test(String s1,String s2);
//}
 public class Main{
	 static String betterString(String s1,String s1,Bipredicate<String,String> isbetter){
		 if(isbetter.test(s1,s2)){
			 return s1;
		 }
		 else{
			 return s2;
		 }
	 }
 

	public static void main(String args[]){
		String s1 = new String ("somaya");
		String s2 = new String ("mohammed");
		
	//String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
   // String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
     System.out.println	("the String"+betterString(s1,s2,(ss1,ss2)->ss1.length() > ss2.length()));
	}
}
	

