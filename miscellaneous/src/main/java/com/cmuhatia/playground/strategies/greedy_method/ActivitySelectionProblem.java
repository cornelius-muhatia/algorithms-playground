package com.cmuhatia.playground.strategies.greedy_method;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * <p>
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 * </p>
 *
 * @see <a href="https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/">Credits: GeeksForGeeks</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ActivitySelectionProblem {

    public static int of(Map.Entry<Integer, Integer> jobsTimeRange) {
        //sort job range by end time
        //for each entry select count non overlapping
        throw new UnsupportedOperationException();
    }
}
