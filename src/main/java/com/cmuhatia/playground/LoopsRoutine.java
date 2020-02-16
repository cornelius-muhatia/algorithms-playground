package com.cmuhatia.playground;

import java.util.List;

public class LoopsRoutine {

    /**
     * Used to print stair case of specified width and length. Example:
     *    #
     *  ##
     * ###
     *####
     * @param length stair width and length
     */
   public static void printStaircase(int length){
        for(int i = 1; i <= length; i++){
            for(int j = length - i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("#");
            }
            System.out.println("");
        }
    }

    /**
     * Given that the number at the position where you are now is P you need to jump P positions to the right in the list.
     * For example, if you are at position 6 and the number at position 6 has the value 3,
     * you need to jump to position 6 + 3 = 9.
     * Repeat this operation until you reach beyond the right-side border of the list. If P is zero return -1
     *
     * @param data {@link List} of {@link Integer}
     * @return number of steps
     */
    public static int jumpOverNumbers(List<Integer> data) {
        int steps = 0;
        int index = 0;
        while (index < data.size()) {
            if (data.get(index) == 0) {
                return -1;
            }
            index = index + data.get(index);
            steps++;

        }
        return steps;
    }

    /**
     * Sum digits in a number
     *
     * @param number {@link Long}
     * @return digits sum
     */
    public static int digitSum(long number) {
        if(number < 0){
            number = Math.abs(number);
        }
        int sum = 0;
        char[] digits = Long.toString(number).toCharArray();
        for(char digit : digits){
            sum += Integer.parseInt(String.valueOf(digit));
        }
        return sum;
    }

    /**
     * Check if number is a numeric palindrome
     * @param number {@link Long}
     * @return {@link Boolean}
     */
    public static boolean isNumericPalindrome(long number){
        String rawString = Long.toString(number);
        return rawString.equals(reverseString(rawString));
    }

    /**
     * Check if number is a numeric palindrome. This solution is a little better than
     * {@link LoopsRoutine#isNumericPalindrome2(long)}
     *
     * @param number {@link Long}
     * @return {@link Boolean}
     */
    public static boolean isNumericPalindrome2(long number) {
        String rawString = Long.toString(number);
        int j = rawString.length() - 1;
        for(int i=0; i < rawString.length(); i++) {
            if(i >= j){
                break;
            }
            if(rawString.charAt(i) != rawString.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }

    public static boolean isNumericPalindrome3(long num) {
        long reversedInteger = 0, remainder, originalInteger;
        originalInteger = num;
        // reversed integer is stored in variable
        while( num != 0 )
        {
            remainder = num % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            num /= 10;
        }
        // palindrome if orignalInteger and reversedInteger are equal
        return (originalInteger == reversedInteger);
    }

    /**
     * Reverses a string
     *
     * @param string input string
     * @return reversed string
     */
    public static String reverseString(String string){
        String reverse = "";
        for(int i = string.length() - 1; i > -1; i--){
            reverse += string.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args){
        LoopsRoutine.printStaircase(4);
    }
}
