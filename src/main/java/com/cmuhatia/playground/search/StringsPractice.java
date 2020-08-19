/*
 * Copyright 2020 Cornelius M.
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
package com.cmuhatia.playground.search;

/**
 * @author Cornelius M.
 * @version 1.0.0, 02/08/2020
 */
public class StringsPractice {

    /**
     * A string is said to be a special string if either of two conditions is met:
     * <ul>
     *     <li>All of the characters are the same, e.g. aaa.</li>
     *     <li>All characters except the middle one are the same, e.g. aadaa.</li>
     * </ul>
     * Full problem statement can be found at <a href="http://hr.gs/3c9b9">Hackerrank</a>
     * @param str string
     * @return special character counts
     */
    public static int countSpecialStrings(String str){
        int n = str.length();
        int subLength = 0;
        int count = 0;
        for(int j = 1; j < n; j++){
            if(str.charAt(j - 1) == str.charAt(j)){
                subLength++;
            } else if(subLength > 0){
                
            }
        }
        return count;
    }
}
