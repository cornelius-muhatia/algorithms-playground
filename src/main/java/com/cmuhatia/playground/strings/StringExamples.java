package com.cmuhatia.playground.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringExamples {

    public static void reverseString(char[] str) {
        for (int i = 0; i < str.length; i++) {
            int lastIdx = str.length - 1 - i;
            if (i >= lastIdx) {
                break;
            }

            char temp = str[i];
            str[i] = str[lastIdx];
            str[lastIdx] = temp;
        }

    }
}
