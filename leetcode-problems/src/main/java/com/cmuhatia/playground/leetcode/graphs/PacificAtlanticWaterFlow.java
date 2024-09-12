package com.cmuhatia.playground.leetcode.graphs;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * </p>
 *
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * </p>
 *
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * </p>
 *
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">LeetCode - Pacific Atlantic Water Flow</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PacificAtlanticWaterFlow {

    /**
     * Inspired by <a href="https://youtu.be/s-VkcjHqkGI?si=yOKhJ9C-Z1rw0dip">Pacific Atlantic Water Flow - Leetcode 417 - Python</a>
     */
    public static List<List<Integer>> of(int[][] heights) {
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                flowToPacific(heights, pacific, r, c);

                flowToAtlantic(heights, atlantic, r, c);
            }
        }

        pacific.retainAll(atlantic);

        return pacific.stream().toList();
    }

    private static void flowToPacific(int[][] heights, Set<List<Integer>> oceanEntries, int r, int c) {
        canTraverse(heights, new HashSet<>(), oceanEntries, 0, 0, r, c);
    }

    private static void flowToAtlantic(int[][] heights, Set<List<Integer>> oceanEntries, int r, int c) {
        canTraverse(heights, new HashSet<>(), oceanEntries, heights.length - 1, heights[0].length - 1, r, c);
    }

    private static boolean canTraverse(
            int[][] heights,
            Set<List<Integer>> visited,
            Set<List<Integer>> oceanEntries,
            int heightBoundary,
            int widthBoundary,
            int r,
            int c
    ) {
        List<Integer> valueLocation = List.of(r, c);

        if (visited.contains(valueLocation)) {
            return false;
        }

        visited.add(valueLocation);

        if (r == heightBoundary || c == widthBoundary) {
            oceanEntries.add(valueLocation);
            return true;
        }
        // Check left value
        if (c > 0 && heights[r][c] >= heights[r][c - 1] && canTraverse(heights, visited, oceanEntries, heightBoundary, widthBoundary, r, c - 1)) {
            oceanEntries.add(valueLocation);
            return true;
        }

        // Check right value
        int rightValIdx = c + 1;
        if (
                rightValIdx < heights[0].length
                        && heights[r][c] >= heights[r][rightValIdx]
                        && canTraverse(heights, visited, oceanEntries, heightBoundary, widthBoundary, r, rightValIdx)
        ) {
            oceanEntries.add(valueLocation);
            return true;
        }

        // Check up value
        if (r > 0 && heights[r][c] >= heights[r - 1][c] && canTraverse(heights, visited, oceanEntries, heightBoundary, widthBoundary, r - 1, c)) {
            oceanEntries.add(valueLocation);
            return true;
        }

        // Check down value
        int downValIdx = r + 1;
        if (
                downValIdx < heights.length
                        && heights[r][c] >= heights[downValIdx][c]
                        && canTraverse(heights, visited, oceanEntries, heightBoundary, widthBoundary, downValIdx, c)
        ) {
            oceanEntries.add(valueLocation);
            return true;
        }

        return false;
    }
}
