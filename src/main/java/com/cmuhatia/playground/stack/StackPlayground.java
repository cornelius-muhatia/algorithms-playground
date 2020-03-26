package com.cmuhatia.playground.stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackPlayground {

    public static void main(String[] args){
        ArrayList<String> test;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Current stack size before iteration " + stack.size());
        stack.forEach(System.out::println);
        System.out.println("Current stack size after iteration " + stack.size());
        stack.remove(2);
        stack.forEach(System.out::println);
//        Heap<String> heap;
    }
}
