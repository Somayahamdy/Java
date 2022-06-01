public class Numocc222 {
public static void main(String args[]) {
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
}
}
}