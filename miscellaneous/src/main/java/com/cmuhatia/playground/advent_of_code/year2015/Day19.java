package com.cmuhatia.playground.advent_of_code.year2015;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day19 {
    public static int getDistinctReplacement(String[] input, String molecule) {
        Set<String> distinctMolecules = new HashSet<>(input.length);

        for (String str : input) {
            String oldString = str.substring(0, str.indexOf(" "));
            String symbol = str.substring(str.lastIndexOf(" ") + 1);

            for (int i = 0; i < str.length(); i++) {
                String newString = replace(molecule, i, oldString, symbol);

                if (newString != null) {
                    distinctMolecules.add(newString);
                }
            }
        }

        return distinctMolecules.size();
    }

    private static String replace(String str, int startIdx, String oldString, String replacement) {
        int strIdx = str.indexOf(oldString, startIdx);
        if (strIdx == -1) {
            return null;
        }

        return str.substring(0, strIdx) + replacement + str.substring(strIdx + oldString.length());
    }
}
