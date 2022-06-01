//package pack;

import java.util.*;

public class CCOLECT {
    public static void print(HashMap <Character, ArrayList<String>> dict)
    {
        for (char k: dict.keySet()) {
            char key = k;
            ArrayList<String> value = dict.get(k);
            System.out.println(key + " " + value);
        }
    }
    public static void printValues(char letter,HashMap <Character, ArrayList<String>> dict ) {
        for (char k : dict.keySet()) {
            char key = k;
            if(key == letter) {
                ArrayList<String> value = dict.get(key);
                System.out.println(key + " " + value);
            }
        }
    }
    public static HashMap Dictionary(String [] words)
    {
        
        List word = Arrays.asList(words);
        
        HashMap<Character, ArrayList<String>> dict = new HashMap<>();
        char letter = 'a';
        for (int i = 0; i < 26 ; i++) {
            ArrayList<String>setOfWords = new ArrayList<>();
            for (int j = 0; j < word.size() ; j++) {
                if(word.get(j).toString().charAt(0)==letter)
                    setOfWords.add(word.get(j).toString());
                Collections.sort(setOfWords);
                dict.put(letter,setOfWords);
            }
            letter++;
        }
        return dict;
    }

    public static void main(String[] args) {
	// write your code here
        String[]words = {"apple", "all", "aLLOU", "banana", "yellow","cat","tee","somaya","hamdy","mohammed"};
        HashMap <Character,ArrayList<String>> dict = Dictionary (words);
        print(dict);
        char letter = 'a';
        printValues(letter, dict);

    }
}