package com.cmuhatia.playground.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Cornelius M.
 * @version 1.0.0, 06/08/2021
 */
class UndirectedMatrixWeightedGraphTest {

    @Test
    public void testWeightedGraphMatrix() {
        int[][] graph1Matrix = {
                {0, 3, 0, 2, 0, 0, 0, 0, 4},
                {3, 0, 0, 0, 0, 0, 0, 4, 0},
                {0, 0, 0, 6, 0, 1, 0, 2, 0},
                {2, 0, 6, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 8},
                {0, 0, 1, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 0, 8, 0, 0, 0},
                {0, 4, 2, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 8, 0, 0, 0, 0}
        };

        UndirectedMatrixWeightedGraph graph1 = new UndirectedMatrixWeightedGraph(9);
        graph1.addEdge(0, 1, 3)
                .addEdge(0, 8, 4)
                .addEdge(0, 3, 2)
                .addEdge(1, 0, 3)
                .addEdge(1, 7, 4)
                .addEdge(7, 2, 2)
                .addEdge(2, 3, 6)
                .addEdge(2, 7, 2)
                .addEdge(2, 5, 1)
                .addEdge(3, 0, 2)
                .addEdge(3, 2, 6)
                .addEdge(3, 4, 1)
                .addEdge(4, 3, 1)
                .addEdge(4, 8, 8)
                .addEdge(5, 2, 1)
                .addEdge(5, 6, 8)
                .addEdge(6, 5, 8)
                .addEdge(7, 1, 4)
                .addEdge(7, 2, 2)
                .addEdge(8, 0, 4)
                .addEdge(8, 4, 8)
        ;
        assertEquals(8, graph1.edgeWeight(5, 6));
        assertArrayEquals(graph1Matrix, graph1.getMatrix());
    }

}