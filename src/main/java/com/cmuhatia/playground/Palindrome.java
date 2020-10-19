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

    /**
     * Checks if a string is palindrome using for loop
     * @param str raw string
     * @return true if the string is palindrome otherwise false
     */
    public static boolean isPalindrome(String str){
        for(int i=0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length() - (i+1))){
                return false;
            }
        }
        return true;
    }

    public static String createPalindrome(String str) {
        // code goes here
        String remChars = "";
        int i = 0;
        int j = str.length() - 1;
        boolean isMismatch = false;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                remChars += str.charAt(i);
                if(isMismatch){
                    remChars = remChars.substring(0, remChars.length() - 1);
                    i--;
                    j--;
                } else{
                    isMismatch = true;
                    i++;
                }
            } else{
                isMismatch = false;
                i++;
                j--;
            }
        }
        return remChars;
    }


    public static void main(String[] args){
        System.out.println("Longest String " + longestEvenWord("Time to write great code"));
    }

}
