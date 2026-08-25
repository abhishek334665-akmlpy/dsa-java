/**
 * Demonstrates using a {@link java.util.HashSet} to remove duplicate
 * values from an integer array.
 *
 * <p>Average time complexity: O(n)
 * <br>Space complexity: O(n)
 */

package dsa;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 2, 3, 4, 4 };

		HashSet<Integer> set = new HashSet<>();

		for (int n : nums)
			set.add(n);

		System.out.println(set);
	}
}