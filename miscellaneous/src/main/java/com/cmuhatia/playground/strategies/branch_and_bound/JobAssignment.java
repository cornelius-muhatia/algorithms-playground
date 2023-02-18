package com.cmuhatia.playground.strategies.branch_and_bound;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JobAssignment {

    /**
     * @return assigned job indexes ordered according to param costingTable row indexes
     */
    public static int[] of(int[][] costingTable) {
        if (costingTable.length == 0) {
            return new int[0];
        }

        int minCost = Integer.MAX_VALUE;
        for (int w = 0; w < costingTable.length; w++) {
            int currentCost = Integer.MAX_VALUE;
            for (int j = 0; j < costingTable[0].length; j++) {

            }
        }

        throw new UnsupportedOperationException();
    }

    /**
     * @return assigned job indexes ordered according to param costingTable row indexes
     */
    public static int[] of2(int[][] costingTable) {
        if (costingTable.length == 0) {
            return new int[0];
        }

        int[] selectedIndexes = new int[costingTable[0].length];
        for (int workerIdx = 0; workerIdx < selectedIndexes.length; workerIdx++) {
            int currentVal = Integer.MAX_VALUE;
            for (int col = 0; col < costingTable[0].length; col++) {
                for (int row = 0; row < costingTable.length; row++) {

                }
            }

        }
        return selectedIndexes;
    }

    private static int getLeastCost(int[][] costingTable, Set<Integer> selectedJobs, int jobIdx) {
        int leastCostIdx = -1;

        for (int i = 0; i < costingTable.length; i++) {
            if (selectedJobs.contains(i)) {
                continue;
            }


        }

        return -1;
    }
}
