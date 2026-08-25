/**
 * Demonstrates recursive Depth-First Search (DFS) on a simple graph.
 *
 * <p>DFS explores as far as possible along each branch before backtracking.
 *
 * <p>Time complexity: O(V + E)
 * <br>Space complexity: O(V) including the visited array and recursion stack.
 */

package dsa;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

	static List<Integer>[] graph;

	/** Recursively visits all reachable vertices from {@code node}. */
	static void dfs(int node, boolean[] visited) {

		visited[node] = true;

		System.out.print(node + " ");

		for (int next : graph[node]) {

			if (!visited[next])
				dfs(next, visited);
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		graph = new ArrayList[5];

		for (int i = 0; i < 5; i++)
			graph[i] = new ArrayList<>();

		graph[0].add(1);
		graph[0].add(2);
		graph[1].add(3);
		graph[2].add(4);

		dfs(0, new boolean[5]);
	}
}