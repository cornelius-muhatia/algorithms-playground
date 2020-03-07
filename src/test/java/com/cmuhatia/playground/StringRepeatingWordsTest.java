package com.cmuhatia.playground;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StringRepeatingWordsTest {

    @Test
    public void testSplitString(){
        //best case
        StringBuilder sentence = new StringBuilder("Word");
        Assert.assertEquals(1, StringRepeatingWords.splitString(sentence.toString(), " ").size());
        Assert.assertEquals(0, StringRepeatingWords.splitString("", " ").size());

        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            sentence.append(" ").append(random.longs());
        }
        Assert.assertEquals(1001, StringRepeatingWords.splitString(sentence.toString(), " ").size());

    }

    @Test
    public void getRepeatedWords() {
        //best case
        Assert.assertTrue(StringRepeatingWords.getRepeatedWords("").isEmpty());
        Assert.assertTrue(StringRepeatingWords.getRepeatedWords("Word").isEmpty());
        Assert.assertEquals(1, StringRepeatingWords.getRepeatedWords("Word Word").size());
        Assert.assertEquals(2, StringRepeatingWords.getRepeatedWords("Word Word of tests and tests").size());
    }
}