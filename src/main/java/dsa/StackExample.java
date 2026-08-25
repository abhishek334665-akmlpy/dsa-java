/**
 * Demonstrates LIFO (Last-In, First-Out) behavior using
 * {@link java.util.Stack}.
 *
 * <p>Elements are removed in the reverse order in which they were added.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(n)
 */

package dsa;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		while (!stack.isEmpty())
			System.out.println(stack.pop());
	}
}