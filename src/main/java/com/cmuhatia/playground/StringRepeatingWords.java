package com.cmuhatia.playground;

import java.util.ArrayList;
import java.util.List;

public class StringRepeatingWords {

    /**
     * Split a string into List
     *
     * @param sentence target string
     * @param sep string seperator
     * @return {@link List} of {@link String}
     */
    public static List<String> splitString(String sentence, String sep){
        List<String> words = new ArrayList<>();
        if(sentence.isEmpty()){
            return words;
        }
        while(sentence.length() > 0){
            int firstIndex = sentence.indexOf(sep);
            if(firstIndex == -1){
                words.add(sentence);
                break;
            }
            words.add(sentence.substring(0, firstIndex));
            sentence = sentence.substring(firstIndex + sep.length());
        }
        return words;
    }

    /**
     * Get repeated words in a string
     *
     * @param sentence sentence
     * @return {@link List} of {@link String}
     */
    public static List<String> getRepeatedWords(String sentence){
        List<String> duplicates = new ArrayList<>();
        while(sentence.length() > 0){
            int firstIndex = sentence.indexOf(" ");
            if(firstIndex == - 1){
                break;
            }
            String word = sentence.substring(0, firstIndex);
            sentence = sentence.substring(firstIndex + 1);
            if(sentence.contains(word)){
                duplicates.add(word);
            }
        }
        return duplicates;
    }
}
