import java.lang.String;
//import java.util.function.Predicate;
//interface lambds{
//	abstract void test(String s1,String s2);
//}
	
 public class Main223{
	 	public static void main(String args[]){
		String s1 = new String ("somayaaa");
		String s2 = new String ("mohammeddd");
		
	//String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
   // String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
     System.out.println	("the String is "+s1 +" checking" + checkString(s1));
	 System.out.println	("the String is "+s2 +" checking" + checkString(s2));
	  //System.out.println	("the String is "+checkString(s2,(c) ->Character.isLetter(c)));
	}
	 static boolean checkString (String s){
		
		
			 return s.chars().allMatch(Character::isLetter);
		 
	 }
 
	
 }
 