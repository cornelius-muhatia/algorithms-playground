package com.cmuhatia.playground.search;

public class BinarySearch {

    /**
     * Used to search character in a sorted array
     *
     * @param sortedArray array of sorted characters
     * @param needle search key
     * @return true if exists false otherwise
     */
    public static boolean contains(Character[] sortedArray, Character needle) {
        int mid = (sortedArray.length/2);
        int length = sortedArray.length;
        int start = 0;
        while(length > start) {
            if(sortedArray[mid].equals(needle)) {
                return true;
            } else if(sortedArray[mid].compareTo(needle) < 0) {
                start = mid + 1;
                mid = start + (length - start)/2;
            } else {
                length = mid;
                mid = (mid - 1)/2;
            }
        }
        return false;
    }
}
