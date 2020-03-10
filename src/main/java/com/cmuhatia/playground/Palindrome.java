package com.cmuhatia.playground;

public class Palindrome {

    public static String longestEvenWord(String sentence) {
        // Write your code here
        String [] words = sentence.split(" ");
        String longestEven = "";
        for(String word: words){
            if(word.length() % 2 == 0 && word.length() > longestEven.length()){
                longestEven = word;
            }
        }
        return longestEven.isEmpty() ? "00" : longestEven;
    }

    public static void main(String[] args){
        System.out.println("Longest String " + longestEvenWord("Time to write great code"));
    }

}
