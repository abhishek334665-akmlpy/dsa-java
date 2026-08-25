/**
 * Demonstrates iterative binary search on a sorted integer array.
 *
 * <p>Binary search repeatedly halves the search space.
 *
 * <p>Time complexity: O(log n)
 * <br>Space complexity: O(1)
 */

package dsa;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 7, 9, 11 };

		int low = 0;
		int high = arr.length - 1;
		int target = 7;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] == target) {
				System.out.println(mid);
				return;
			}

			if (arr[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		System.out.println("Not Found");
	}
}