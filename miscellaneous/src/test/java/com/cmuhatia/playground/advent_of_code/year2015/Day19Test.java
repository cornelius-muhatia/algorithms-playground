package com.cmuhatia.playground.advent_of_code.year2015;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day19Test {

    @Test
    void getDistinctReplacement() {
        String[] input = TestUtils.readFileLines("advent_of_code/2015/2015_19_input.txt");
        assertEquals(
                4,
                Day19.getDistinctReplacement(
                        input,
                        "CRnCaCaCaSiRnBPTiMgArSiRnSiRnMgArSiRnCaFArTiTiBSiThFYCaFArCaCaSiThCaPBSiThSiThCaCaPTiRnPBSiThRnFArArCaCaSiThCaSiThSiRnMgArCaPTiBPRnFArSiThCaSiRnFArBCaSiRnCaPRnFArPMgYCaFArCaPTiTiTiBPBSiThCaPTiBPBSiRnFArBPBSiRnCaFArBPRnSiRnFArRnSiRnBFArCaFArCaCaCaSiThSiThCaCaPBPTiTiRnFArCaPTiBSiAlArPBCaCaCaCaCaSiRnMgArCaSiThFArThCaSiThCaSiRnCaFYCaSiRnFYFArFArCaSiRnFYFArCaSiRnBPMgArSiThPRnFArCaSiRnFArTiRnSiRnFYFArCaSiRnBFArCaSiRnTiMgArSiThCaSiThCaFArPRnFArSiRnFArTiTiTiTiBCaCaSiRnCaCaFYFArSiThCaPTiBPTiBCaSiThSiRnMgArCaF"
                )
        );
    }

    @Test
    void getDistinctReplacement2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2015/2015_19_input2.txt");
        assertEquals(4, Day19.getDistinctReplacement(input, "HOH"));
    }

    @Test
    void getDistinctReplacement3() {
        String[] input = TestUtils.readFileLines("advent_of_code/2015/2015_19_input2.txt");
        assertEquals(7, Day19.getDistinctReplacement(input, "HOHOHO"));
    }

    @Test
    void getDistinctReplacement4() {
        String[] input = {
                "Ca => SiTh",
                "Ca => PB",
                "a => OB"
        };
        assertEquals(6, Day19.getDistinctReplacement(input, "CaCa"));
    }
}