/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmuhatia.playground.search;

import com.cmuhatia.playground.search.BreadthFirstSearch;
import com.cmuhatia.playground.search.Tree;
import java.util.Optional;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cornelius
 */
public class BreadthFirstSearchTest {
    
    public BreadthFirstSearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
        
        Assert.assertTrue("Breadth first search best case", BreadthFirstSearch.search('H', root).isPresent());
        Assert.assertTrue("Breadth first root search", BreadthFirstSearch.search('F', root).isPresent());
        Assert.assertTrue("Breadth first search worst case", !BreadthFirstSearch.search('Z', root).isPresent());
        
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
        
        Assert.assertTrue("Graph search best case 1", BreadthFirstSearch.search('Y', ongwaro).isPresent());
        Assert.assertTrue("Graph search best case 2", BreadthFirstSearch.search('C', yaya).isPresent());
        Assert.assertTrue("Graph search worst case 1", !BreadthFirstSearch.search('E', ongwaro).isPresent());
    }
    
}
