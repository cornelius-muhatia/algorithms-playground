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

    /**
     * Checks if a number is <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a> i.e. 1001 is palindrome.
     * Refer to <a href="https://www.programiz.com/c-programming/examples/palindrome-number">Programiz implementation</a>
     *
     * @param no number
     * @return true if number is palindrome otherwise false.
     */
    public static boolean isPalindrome(int no){
        int head = no;
        int tail = 0;
        while(head != 0){
            int remainder = head % 10;
            head = head/10;
            tail = (tail * 10) + remainder;
            if(head == tail){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println("Longest String " + longestEvenWord("Time to write great code"));
    }

}
