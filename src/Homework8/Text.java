package Homework8;

import java.util.*;

public class Text {
    public static void main(String[] args) {
        String text = "aaa bbb ccc ddd ddd ddd aaa ccc bbb";
        List<String> words = Arrays.asList(text.split("\\s"));
        words.forEach(System.out::println);
        Set<String> uniqueWords= new HashSet<>();
        uniqueWords.addAll(words);
        Map<String, Integer> uniqueWordsInText = new HashMap<>();
        for (String elements : uniqueWords) {
            int repeatOfWord = 0;
            for (int i = 0; i <words.size() ; i++) {
                if(elements.equals(words.get(i))){
                    repeatOfWord+=1;
                }
            }
            System.out.println(elements + " " + repeatOfWord);
            uniqueWordsInText.put(elements, repeatOfWord);
        }
    }
}
