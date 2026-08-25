/**
 * Demonstrates the fixed-size sliding-window technique for finding
 * the maximum sum of a contiguous subarray of size {@code k}.
 *
 * <p>The window is updated incrementally instead of recalculating
 * every subarray sum.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(1)
 */

package dsa;

public class SlidingWindow {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 1, 3, 2 };

		int k = 3;

		int sum = 0;

		for (int i = 0; i < k; i++)
			sum += arr[i];

		int max = sum;

		for (int i = k; i < arr.length; i++) {

			sum += arr[i];
			sum -= arr[i - k];

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}