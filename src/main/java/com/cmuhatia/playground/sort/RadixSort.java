/*
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground.sort;

/**
 * @version 1.0.0, 14/05/2022
 */
public class RadixSort {

    /**
     * Credits: <a href="https://youtu.be/Il45xNUHGp0">Jenny's Lectures</a>
     *
     * @param k largest value within the array
     * @return sorted array
     */
    public static int[] sort(int[] array, int k) {
        for (int placeVal = 1; (k / placeVal) > 0; placeVal = (placeVal * 10)) {
            array = countSort(array, placeVal);
        }

        return array;
    }

    private static int[] countSort(int[] array, int placeVal) {
        int[] keysCountArray = new int[10];
        int[] sortedArray = new int[array.length];

        for (int j : array) {
            keysCountArray[getPlaceValue(j, placeVal)]++;
        }

        for (int i = 1; i < 10; i++) {
            keysCountArray[i] = keysCountArray[i] + keysCountArray[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int countArrIdx = getPlaceValue(array[i], placeVal);
            int sortedArrayIdx = --keysCountArray[countArrIdx];
            sortedArray[sortedArrayIdx] = array[i];
        }

        return sortedArray;
    }

    private static int getPlaceValue(int no, int placeVal) {
        return (no / placeVal) % 10;
    }
}
