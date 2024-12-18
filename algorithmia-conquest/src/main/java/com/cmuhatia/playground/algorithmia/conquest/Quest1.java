package com.cmuhatia.playground.algorithmia.conquest;

import lombok.NoArgsConstructor;

/**
 * @author cmuhatia
 * @see <a href="https://everybody.codes/event/2024/quests/1 ">Quest 1</a>
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Quest1 {

    public static int part1(String input) {
        int count = 0;

        for (var c : input.toCharArray()) {
            if (c == 'B') {
                count++;
            }

            if (c == 'C') {
                count += 3;
            }
        }

        return count;
    }

    public static int part2(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i += 2) {
//            int sum = sumPair(input.charAt(i), input.charAt(i + 1));
            int sum = sumPair(input.substring(i, i + 2));
            count = count + sum;
        }

        return count;
    }

    private static int sumPair(String pair) {
        // A
        if ("AA".equalsIgnoreCase(pair)) return 2;

        if ("AB".equalsIgnoreCase(pair) || "BA".equalsIgnoreCase(pair)) return 4;

        if ("AC".equalsIgnoreCase(pair) || "CA".equalsIgnoreCase(pair)) return 5;

        if ("AD".equalsIgnoreCase(pair) || "DA".equalsIgnoreCase(pair)) return 7;

        if ("AX".equalsIgnoreCase(pair) || "XA".equalsIgnoreCase(pair)) return 0;

        // B
        if ("BB".equalsIgnoreCase(pair)) return 4;

        if ("BC".equalsIgnoreCase(pair) || "CB".equalsIgnoreCase(pair)) return 6;

        if ("BD".equalsIgnoreCase(pair) || "DB".equalsIgnoreCase(pair)) return 8;

        if ("XB".equalsIgnoreCase(pair) || "BX".equalsIgnoreCase(pair)) return 1;

        // C
        if ("CC".equalsIgnoreCase(pair)) return 8;

        if ("CD".equalsIgnoreCase(pair) || "DC".equalsIgnoreCase(pair)) return 10;

        if ("XC".equalsIgnoreCase(pair) || "CX".equalsIgnoreCase(pair)) return 3;


        // D
        if ("DD".equalsIgnoreCase(pair)) return 12;

        if ("XD".equalsIgnoreCase(pair) || "DX".equalsIgnoreCase(pair)) return 5;

        return 0;
    }

    private static int sumPair(char a, char b) {
        // A
        int aa = 'A' * 'A';

        if (a * b == aa) return 2;

        int ab = 'A' * 'B';
        if (a * b == ab) return 4;

        int ac = 'A' * 'C';
        if (a * b == ac) return 5;

        int ad = 'A' * 'D';
        if (a * b == ad) return 7;

        int xa = 'x' * 'A';
        if (a * b == xa) return 0;

        // B
        int bb = 'B' * 'B';
        if (a * b == bb) return 4;

        int bc = 'B' * 'C';
        if (a * b == bc) return 6;

        int bd = 'B' * 'D';
        if (a * b == bd) return 8;

        int xb = 'x' * 'B';
        if (a * b == xb) return 1;

        // C
        int cc = 'C' * 'C';
        if (a * b == cc) return 8;

        int cd = 'C' * 'D';
        if (a * b == cd) return 10;

        int xc = 'x' * 'C';
        if (a * b == xc) return 3;


        // D
        int dd = 'D' * 'D';
        if (a * b == dd) return 12;

        int xd = 'x' * 'D';
        if (a * b == xd) return 5;

        return 0;
    }
}
