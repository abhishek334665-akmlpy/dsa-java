/**
 * Demonstrates the two-pointer technique for finding two values
 * in a sorted array whose sum equals a target.
 *
 * <p>One pointer starts at each end of the array. The pointers move
 * toward each other based on the current sum.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(1)
 */

package dsa;

public class TwoPointers {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 7, 11, 15 };

		int left = 0;
		int right = arr.length - 1;
		int target = 15;

		while (left < right) {

			int sum = arr[left] + arr[right];

			if (sum == target) {
				System.out.println(left + "," + right);
				break;
			}

			if (sum < target)
				left++;
			else
				right--;
		}
	}
}