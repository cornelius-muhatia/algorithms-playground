/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmuhatia.playground.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 *
 * @author cornelius
 */
public class BreadthFirstSearchTest {
    
    public BreadthFirstSearchTest() {
    }

    /**
     * Test of search method, of class BreadthFirstSearch.
     */
    @Test
    public void testTreeSearch() {
        Tree<Character> root = Tree.of('F');
        
        Tree<Character> b = root.addChild('B');
        Tree<Character> a = b.addChild('A');
        Tree<Character> d = b.addChild('D');
        Tree<Character> c = d.addChild('C');
        Tree<Character> e = d.addChild('E');        
        
        Tree<Character> g = root.addChild('G');
        Tree<Character> i = g.addChild('I');
        Tree<Character> h = i.addChild('H');
        
        assertTrue(BreadthFirstSearch.search('H', root).isPresent());
        assertTrue(BreadthFirstSearch.search('F', root).isPresent());
        assertTrue(!BreadthFirstSearch.search('Z', root).isPresent());
        
//        assertTrue(true);
    }
    
    @Test
    public void testGraphSearch(){
        Node<Character> cbd = new Node<>('C');
        Node<Character> westy = new Node<>('W');
        cbd.connect(westy);
        Node<Character> hurl = new Node<>('H');
        cbd.connect(hurl);
        Node<Character> yaya = new Node<>('Y');
        westy.connect(yaya);
        Node<Character> uthiru = new Node<>('U');
        westy.connect(uthiru);
        Node<Character> ongwaro = new Node<>('K');
        uthiru.connect(ongwaro);
        yaya.connect(ongwaro);
        
        assertTrue(BreadthFirstSearch.search('Y', ongwaro).isPresent());
        assertTrue(BreadthFirstSearch.search('C', yaya).isPresent());
        assertTrue(!BreadthFirstSearch.search('E', ongwaro).isPresent());
    }
    
}
