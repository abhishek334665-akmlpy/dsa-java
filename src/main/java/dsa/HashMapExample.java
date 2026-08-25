/**
 * Demonstrates using a {@link java.util.HashMap} to count frequencies
 * of values in an integer array.
 *
 * <p>Average time complexity: O(n)
 * <br>Space complexity: O(n)
 */

package dsa;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 2, 5, 7, 2 };

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		System.out.println(map);
	}
}