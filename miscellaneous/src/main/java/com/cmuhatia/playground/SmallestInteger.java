/*
 * Copyright 2019 Cornelius M.
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

package com.cmuhatia.playground;

import java.util.Arrays;

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 25, 2019 
 */
public class SmallestInteger {
    
    public static int solution(int[] A){
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if((i + 1) != A[i]){
                return i + 1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args){
        int A[] = {1, 3, 6, 4, 1, 2};
        System.out.println("Lowest omitted value " + solution(A));
    }

}
