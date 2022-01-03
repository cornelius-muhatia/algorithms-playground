package com.cmuhatia.playground.heap;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Cornelius M.
 * @version 1.0.0, 11/06/2020
 */
public class MaxHeapTest {

    @Test
    public void addAll() {
        MaxHeap<Integer> heap = new MaxHeap<>(List.of(100, 19, 36, 17, 12, 25, 5, 9, 15, 6, 11, 13, 8, 1, 200));
        assertEquals(Integer.valueOf(200), heap.get(0));
        assertEquals(Integer.valueOf(200), heap.getMax());
    }

    @Test
    public void add() {
        MaxHeap<Integer> heap = new MaxHeap<>(List.of(100, 19, 36, 17, 12, 25, 5, 9, 15, 6, 11, 13, 8, 1, 4));
        heap.add(300);
        assertEquals(Integer.valueOf(300), heap.get(0));
        assertEquals(Integer.valueOf(300), heap.getMax());
    }

    @Test
    public void removeRoot(){
        MaxHeap<Integer> heap = new MaxHeap<>(9);
        heap.add(100);
        heap.add(19);
        heap.add(36);
        heap.add(17);
        heap.add(3);
        heap.add(25);
        heap.add(1);
        heap.add(2);
        heap.add(7);
        System.out.println(heap);
        heap.extractMax();
        System.out.println(heap);
        assertEquals(Integer.valueOf(36), heap.getMax());
    }

    @Test
    public void remove(){
        MaxHeap<Integer> heap = new MaxHeap<>(9);
        heap.add(100);
        heap.add(19);
        heap.add(36);
        heap.add(17);
        heap.add(3);
        heap.add(25);
        heap.add(1);
        heap.add(2);
        heap.add(7);
        System.out.println(heap);

        heap.remove(2);
        System.out.println(heap);

    }
}