/**
 * Demonstrates FIFO (First-In, First-Out) behavior using a queue.
 *
 * <p>{@link java.util.Queue#offer(Object)} adds elements and
 * {@link java.util.Queue#poll()} removes them from the front.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(n)
 */

package dsa;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(10);
		queue.offer(20);
		queue.offer(30);

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}