import java.lang.String;
interface  Lambda{
	String betterString(String s1,String s2);
}

public class Labbetter
{
	public static void main(String args[]){
	String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
    String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
     System.out.println	("the String"+first);
	}
	

