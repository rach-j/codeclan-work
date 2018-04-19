package com.example.user.wordcounterlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 19/03/2018.
 */

public class StringFunctions {

    private String stringOfWords;

    public StringFunctions(String words) {
        this.stringOfWords = words;
    }

    public int wordCount() {

        String[] arrayOfWords = this.stringOfWords.split("\\W+");
        return arrayOfWords.length;
    }

    public String getWordTally() {
        String[] arrayOfWords = this.stringOfWords.toLowerCase().split("\\W+");
        ArrayList<String> arrayListOfWords = new ArrayList<>(Arrays.asList(arrayOfWords));


        HashMap<String, Integer> wordTally = new HashMap<>();
        for (String word : arrayOfWords) {
            int numberOfOccurrences = Collections.frequency(arrayListOfWords, word);
            wordTally.put(word, numberOfOccurrences);
        }
        String result = "";
        for (String key : wordTally.keySet()) {
            String value = wordTally.get(key).toString();
            result = result + key + " : " + value + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

// Better to be 2 separate functions? (One returns hashmap and one to convert hashmap to string?)
// If so, how to set up a new function separate from a class that just takes parameter inputs? Hashmap converter class?

    public String getSortedWordTally() {
        String[] arrayOfWords = this.stringOfWords.toLowerCase().split("\\W+");
        ArrayList<String> arrayListOfWords = new ArrayList<>(Arrays.asList(arrayOfWords));


        HashMap<String, Integer> wordTally = new HashMap<>();
        for (String word : arrayOfWords) {
            int numberOfOccurrences = Collections.frequency(arrayListOfWords, word);
            wordTally.put(word, numberOfOccurrences);
        }

        Object[] wordTallyToBeSorted = wordTally.entrySet().toArray();
        Arrays.sort(wordTallyToBeSorted, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });
        String result = "";
        for (Object e : wordTallyToBeSorted) {
            result = result + ((Map.Entry<String, Integer>) e).getKey() + " : " + ((Map.Entry<String, Integer>) e).getValue() + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

//    Works but I'm not sure I understand how.


}
