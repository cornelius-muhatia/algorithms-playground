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
public class CountingSort {

    /**
     * Only efficient when k is linear/close to the array length
     *
     * @param k largest value within the array
     * @return sorted array
     */
    public static int[] sort(int[] arr, int k) {
        int keysCountArrLength = k + 1;
        int[] keysCountArr = new int[keysCountArrLength];

        int[] sortedArray = new int[arr.length];

        for (int j : arr) {
            keysCountArr[j]++;
        }

        for (int i = 1; i < keysCountArrLength; i++) {
            keysCountArr[i] = keysCountArr[i] + keysCountArr[i-1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int countArrIdx = arr[i];
            int sortedArrayIdx = --keysCountArr[countArrIdx];
            sortedArray[sortedArrayIdx] = arr[i];
        }

        return sortedArray;
    }
}
