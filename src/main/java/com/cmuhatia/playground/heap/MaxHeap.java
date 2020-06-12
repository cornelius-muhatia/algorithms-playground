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
package com.cmuhatia.playground.heap;

import java.util.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 11/06/2020
 */
public class MaxHeap<T extends  Comparable<T>> extends ArrayList<T>{

    /**
     * Initializes a heap with initialCapacity size
     *
     * @param initialCapacity size of the heap
     */
    public MaxHeap(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Default constructor
     */
    public MaxHeap() {
    }

    /**
     * Initializes a heap using the elements from the collection
     *
     * @param c the collection whose elements are to be placed in the heap.
     */
    public MaxHeap(Collection<? extends T> c) {
        super(c.size());
        addAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c){
        for (T t : c) {
            add(t);
        }
        return true;
    }

    /**
     * Return maximum element in the case of Maximum heap it will be the root element/node
     *
     * @return root element
     */
    public T getMax(){
        return isEmpty() ? null : get(0);
    }

    /**
     * Used to re-balance the heap by shifting large element up towards the root element.
     */
    private void shiftUp(){
        int i = size() - 1;
        while(i > 0){
            int k = (i % 2 == 0) ? ((i - 2) / 2) : ((i - 1) / 2);
            if(get(i).compareTo(get(k)) > 0){
                swap(k, i);
            }
            i = k;
        }
    }

    /**
     * Swaps 2 elements
     *
     * @param idxFirst index of the first element
     * @param idxSecond index of the second element
     */
    private void swap(int idxFirst, int idxSecond){
        T temp = get(idxFirst);
        super.set(idxFirst, get(idxSecond));
        super.set(idxSecond, temp);
    }

    /**
     * Re-balances the sub-tree from the specified index
     *
     * @param index index
     */
    public void shiftDown(int index){
        int i = index;
        int size = size() - 1;
        while(i < size){
            int leftIdx = (2 * i) + 1;
            int rightIdx = (2 * i) + 2;

            if(rightIdx < size() && get(rightIdx).compareTo(get(leftIdx)) > 0){
                if(get(i).compareTo(get(rightIdx)) < 0) {
                    swap(i, rightIdx);
                }
                i = rightIdx;
            } else if((leftIdx < size()) && (get(i).compareTo(get(leftIdx)) < 0)){
                swap(i, leftIdx);
                i = leftIdx;
            } else{
                break;
            }
        }
    }

    @Override
    public boolean add(T t){
        boolean modified = super.add(t);
        if(modified){
            this.shiftUp();
        }
        return modified;
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported");
    }

    /**
     * Removes the root node
     *
     * @return root node
     */
    public T extractMax(){
        if(isEmpty()){
            return null;
        }
        T root = get(0);
        super.set(0, get(size() - 1));
        super.remove(size() - 1);
        shiftDown(0);
        return root;
    }

    @Override
    public T remove(int index) {
        if(isEmpty()){
            return null;
        }
        T root = get(index);
        super.set(index, get(size() - 1));
        super.remove(size() - 1);
        shiftDown(index);
        return root;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    /**
     * Checks if the specified index is a leaf index
     *
     * @param index index
     * @return returns true if is a leaf index
     */
    public boolean isLeaf(int index){
        return (index + 1) > (size() / 2);
    }

    @Override
    public String toString(){
        int i = 0;
        StringBuilder str = new StringBuilder(super.toString() + "\n");
        while (i < size()) {
            if(isLeaf(i)){
                i++;
                continue;
            }
            str.append("Parent: ").append(get(i)).append("\n");
            int leftIdx = (2 * i) + 1;
            int rightIdx = (2 * i) + 2;
            if(leftIdx < size()) {
                str.append("\tLeft: ").append(get(leftIdx));
            }
            if(rightIdx < size()){
                str.append("\tRight: ").append(get(rightIdx));
            }
            str.append("\n");
            i++;

        }
        return str.toString();
    }
}
