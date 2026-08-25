/**
 * Demonstrates Breadth-First Search (BFS) on a simple graph.
 *
 * <p>BFS visits vertices level by level using a queue and a visited array.
 *
 * <p>Time complexity: O(V + E)
 * <br>Space complexity: O(V)
 */

package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		List<Integer>[] graph = new ArrayList[5];

		for (int i = 0; i < 5; i++)
			graph[i] = new ArrayList<>();

		graph[0].add(1);
		graph[0].add(2);
		graph[1].add(3);
		graph[2].add(4);

		Queue<Integer> q = new LinkedList<>();

		boolean[] visited = new boolean[5];

		q.offer(0);
		visited[0] = true;

		while (!q.isEmpty()) {

			int node = q.poll();

			System.out.print(node + " ");

			for (int next : graph[node]) {

				if (!visited[next]) {

					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}