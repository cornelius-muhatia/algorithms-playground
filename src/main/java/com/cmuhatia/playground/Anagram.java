package com.cmuhatia.playground;

public class Anagram {

    /**
     * Returns a number denoting the number of characters you must delete to make the two strings anagrams of each other.
     * @param a first string
     * @param b second string
     * @return number of characters
     */
    public static int makeAnagram(String a, String b) {
        int[] charCounts = new int[255];

        for (int i = 0; i < a.length(); i++) {
            charCounts[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            charCounts[b.charAt(i)]--;
        }

        int charDeletionCount = 0;

        for (int charCount : charCounts) {
            if (charCount != 0) {
                charDeletionCount += Math.abs(charCount);
            }
        }

        return charDeletionCount;
    }

    /**
     * Checks if 2 strings are anagrams
     * @param a first string
     * @param b second string
     * @return true if they are anagrams. False otherwise
     */
    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int ASCII_CAPACITY = 255;
        int[] count = new int[ASCII_CAPACITY];
        for (int i=0; i < a.length(); i++){
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        for(int val : count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
