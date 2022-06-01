1
=====
public class Numocc {
public static void main(String args[]) {
String string = "Spring is beautiful but so is winter";
String word = "winter";
String temp[] = string.split(" ");
int count = 0;
for (int i = 0; i < temp.length; i++) {
if (word.equals(temp[i]))
count++;
}
System.out.println("The string is: " + string);
System.out.println("The word " + word + " occurs " + count + " times in the above string");
}
}


2
=====
String str = "Winter is beautiful is coming"; 
String word;
int wordsLen, count;      
String words[] = str.split(" ");
wordsLen = words.length;
for(int i=0; i<wordsLen; i++)
{
word = words[i];
count = 1;
for(int j=(i+1); j<(wordsLen-1); j++)
{
if(word.equals(words[j]))
{
count++;
for(int k=j; k<(wordsLen-1); k++)
{
words[k] = words[k+1];
}
wordsLen--;
j--;
}
}
System.out.println(word+ " occurs " +count);
count = 0;






//main:
System.out.println(countWordsUsingStringTokenizer("Winter is beautiful is coming","www"));

out of main:
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





String s1 = "SairamkrishnaxxxxxMammahe";
Pattern pattern = Pattern.compile("h");
Matcher  matcher = pattern.matcher(s1);
int count = 0;     
while (matcher.find())count++;
System.out.println(count);