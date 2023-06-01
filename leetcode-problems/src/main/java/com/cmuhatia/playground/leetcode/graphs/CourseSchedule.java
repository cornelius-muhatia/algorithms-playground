package com.cmuhatia.playground.leetcode.graphs;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * </p>
 *
 * <p>
 * Return true if you can finish all courses. Otherwise, return false.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/course-schedule/">LeetCode - Course Schedule</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseSchedule {

    /**
     * Credits to: <a href="https://youtu.be/EgI5nU9etnU">NeetCode - Youtube</a>
     */
    public static boolean of(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = initializeGraph(numCourses, prerequisites);

        Set<Integer> visit = new HashSet<>(numCourses);
        for (var entry : graph.entrySet()) {
            if (hasCycle(graph, entry.getKey(), visit)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Integer, List<Integer>> initializeGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);

        for (int[] courses : prerequisites) {
            graph.compute(courses[0], (key, value) -> {
                if (value == null) {
                    List<Integer> children = new LinkedList<>();
                    children.add(courses[1]);

                    return children;
                }

                value.add(courses[1]);

                return value;
            });

            graph.computeIfAbsent(courses[1], value -> new LinkedList<>());
        }

        return graph;
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> graph, Integer key, Set<Integer> visit) {
        if (visit.contains(key)) {
            return true;
        }

        if (graph.get(key).isEmpty()) {
            return false;
        }

        visit.add(key);
        for (Integer descendant : graph.get(key)) {
            if (hasCycle(graph, descendant, visit)) {
                return true;
            }
        }

        graph.put(key, List.of());
        visit.remove(key);

        return false;
    }
}
