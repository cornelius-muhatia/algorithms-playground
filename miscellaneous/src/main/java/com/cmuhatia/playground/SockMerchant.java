/*
 * Copyright 2019 Cornelius M.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cornelius M
 * @version 1.0.0 11/23/19
 */
public class SockMerchant {
    

    static int sockMerchant(List<String> aList) {
        int p = 0;
        for(int i = 0;  i < aList.size(); i++){
            int i2 = aList.lastIndexOf(aList.get(i));
            if( i2 > i) {
                p++;
                aList.remove(i2);
                aList.remove(i);
                i = -1;
            }
        }
        return p;
    }

    public static void main(String[] args){
        List<String> ar = new ArrayList<>();
        String raw = "1 1 3 1 2 1 3 3 3 3";
        String[] arItems = raw.split(" ");

        ar.addAll(Arrays.asList(arItems)); // ar[i] = arItem;

        System.out.printf("Number of pairs is %d", SockMerchant.sockMerchant(ar));
    }
}
