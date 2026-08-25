package main.java.dsa;

import java.util.Arrays;

/**
 * Demonstrates interval conflict detection.
 *
 * <p>Intervals are sorted by start time. If an interval starts
 * before the previous interval ends, a conflict exists.
 *
 * <p>Time complexity: O(n log n).
 * <br>Space complexity: O(1) apart from sorting requirements.
 */
public class MeetingRooms {

    public static boolean canAttendAll(int[][] meetings) {

        if (meetings.length <= 1) {
            return true;
        }

        Arrays.sort(
                meetings,
                (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 1; i < meetings.length; i++) {

            if (meetings[i][0] < meetings[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] meetings = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(
                "Can attend all meetings: "
                        + canAttendAll(meetings)
        );
    }
}