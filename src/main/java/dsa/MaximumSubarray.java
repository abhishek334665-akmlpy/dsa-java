package main.java.dsa;

/**
 * Demonstrates Kadane's algorithm for finding the maximum
 * sum of a contiguous subarray.
 *
 * <p>The algorithm maintains the best subarray ending at the
 * current position and the best result seen so far.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(1)
 */
public class MaximumSubarray {

    public static int maxSubarraySum(int[] nums) {

        int currentSum = nums[0];
        int maximumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(
                    nums[i],
                    currentSum + nums[i]
            );

            maximumSum = Math.max(
                    maximumSum,
                    currentSum
            );
        }

        return maximumSum;
    }

    public static void main(String[] args) {

        int[] nums = {
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        System.out.println(
                "Maximum subarray sum: "
                        + maxSubarraySum(nums)
        );
    }
}