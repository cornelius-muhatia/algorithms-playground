package com.cmuhatia.playground;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class StringRepeatingWordsTest {

    @Test
    public void testSplitString(){
        //best case
        StringBuilder sentence = new StringBuilder("Word");
        assertEquals(1, StringRepeatingWords.splitString(sentence.toString(), " ").size());
        assertEquals(0, StringRepeatingWords.splitString("", " ").size());

        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            sentence.append(" ").append(random.longs());
        }
        assertEquals(1001, StringRepeatingWords.splitString(sentence.toString(), " ").size());

    }

    @Test
    public void getRepeatedWords() {
        //best case
        assertTrue(StringRepeatingWords.getRepeatedWords("").isEmpty());
        assertTrue(StringRepeatingWords.getRepeatedWords("Word").isEmpty());
        assertEquals(1, StringRepeatingWords.getRepeatedWords("Word Word").size());
        assertEquals(2, StringRepeatingWords.getRepeatedWords("Word Word of tests and tests").size());
    }
}