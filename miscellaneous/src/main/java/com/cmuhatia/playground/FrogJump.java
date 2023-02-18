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

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 24, 2019 
 */
public class FrogJump {
     public static int solution(int X, int Y, int D){
          BigDecimal r = new BigDecimal(Y).subtract(new BigDecimal(X));
          r = r.divide(new BigDecimal(D), MathContext.DECIMAL128);
          return r.setScale(0, RoundingMode.CEILING).intValue();
          
      }
     
     public static void main(String[] args){
         System.out.println("Frog steps " + solution(10, 85, 35));
     }
}
