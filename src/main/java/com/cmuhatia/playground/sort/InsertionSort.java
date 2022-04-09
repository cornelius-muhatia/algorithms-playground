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
 * Worst case complexity for insertion sort: O(n^2)
 * @version 1.0.0, 09/04/2022
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int cursorPosition = i;

            int previousIndex = i - 1;
            for (int j = previousIndex; j >= 0; j--) {

                if (array[j].compareTo(array[cursorPosition]) > 0) {
                    swapValues(array, j, cursorPosition);
                    cursorPosition--;

                    continue;
                }

                break;
            }
        }
    }

    private static <T extends Comparable<T>> void swapValues(T[] array, int firstIndex, int secondIndex) {
        T currentValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = currentValue;
    }
}
