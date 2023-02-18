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

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 24, 2019 
 */
public class BinaryGap {
    
    public static long solution(int n){
        String bStr = Integer.toBinaryString(n);
        String[] zeros = bStr.split("1+");
        System.out.println(bStr + " => Zeros splits " + ArrayUtils.toString(zeros) + " last index of zero " + bStr.lastIndexOf("0") + " length " + bStr.length());
        int l = 0;
        int length = (bStr.lastIndexOf("0") == (bStr.length() - 1)) ? (zeros.length - 1) : zeros.length;
        int i0 = (zeros.length > 0 && zeros[0].isEmpty()) ? 0 : 1;
        for(int i = i0; i < length; i++){
            if(l < zeros[i].length()){
                l = zeros[i].length();
            }
        }
        return l;
    }
    
    public static void main(String[] args){
        long length = solution(1);
        System.out.println("Binary gap is "+ length);
    }

}
