package main.java.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the Merge Intervals pattern.
 *
 * <p>Overlapping intervals are merged after sorting them
 * by their starting position.
 *
 * <p>Time complexity: O(n log n)
 * <br>Space complexity: O(n)
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart <= end) {
                end = Math.max(end, currentEnd);
            } else {
                merged.add(new int[]{start, end});

                start = currentStart;
                end = currentEnd;
            }
        }

        merged.add(new int[]{start, end});

        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {9, 12}
        };

        int[][] result = merge(intervals);

        System.out.println("Merged intervals:");

        for (int[] interval : result) {
            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}