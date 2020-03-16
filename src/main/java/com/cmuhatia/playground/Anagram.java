package com.cmuhatia.playground;

public class Anagram {

    /**
     * Returns a number denoting the number of characters you must delete to make the two strings anagrams of each other.
     * @param a first string
     * @param b second string
     * @return number of characters
     */
    public static int makeAnagram(String a, String b) {
        return countMismatchChar(a, b) + countMismatchChar(b, a);
    }

    /**
     * Return number characters not occurring in string b from string a
     * @param a string
     * @param b string
     * @return number of characters
     */
    public static int countMismatchChar(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            char currentChar = a.charAt(i);
            if(b.indexOf(currentChar) == -1){
                count++;
            } else if(a.indexOf(currentChar) == i){
                int countA = countCharOccur(a, currentChar);
                int countB = countCharOccur(b, currentChar);
                if(countA > countB){
                    count += (countA - countB);
                }
            }
        }
        return count;
    }

    /**
     * count number of times the character occurs in a string
     * @param a string
     * @param c target character
     * @return number of occurrence
     */
    public static int countCharOccur(String a, char c){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
}
