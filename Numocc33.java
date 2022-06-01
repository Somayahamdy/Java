import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Numocc33 {
public static void main(String args[]) {
String s1 = "SairamkrishnaxxxxxMammahe";
Pattern pattern = Pattern.compile("h");
Matcher  matcher = pattern.matcher(s1);
int count = 0;     
while (matcher.find())count++;
System.out.println(count);
}
}
