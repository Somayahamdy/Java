import java.util.StringTokenizer;
public class Numocc3 {
public static void main(String args[]) {

System.out.println(countWordsUsingStringTokenizer("Winter is beautiful is coming","www"));

}
public static int countWordsUsingStringTokenizer(String string,String word) {
    if (string == null || string.isEmpty()) {
      return 0;
    }
    StringTokenizer tokens = new StringTokenizer(word);
    String temp[] = string.split(" ");
    int count = 0;
    for (int i = 0; i < temp.length; i++) {
    if (word.equals(temp[i]))
    count++;
    }
    return count;
	}
}