package main.java.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates cycle detection in a directed graph using DFS.
 *
 * <p>The algorithm maintains two states:
 * <ul>
 *     <li>visited - the node has already been processed</li>
 *     <li>path - the node is currently in the DFS recursion path</li>
 * </ul>
 *
 * <p>If DFS reaches a node already present in the current path,
 * a directed cycle exists.
 *
 * <p>Time complexity: O(V + E).
 * <br>Space complexity: O(V + E).
 */
public class GraphCycleDetection {

    public static boolean hasCycle(
            List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        boolean[] path = new boolean[graph.size()];

        for (int node = 0; node < graph.size(); node++) {

            if (!visited[node]
                    && dfs(graph, node, visited, path)) {

                return true;
            }
        }

        return false;
    }

    private static boolean dfs(
            List<List<Integer>> graph,
            int node,
            boolean[] visited,
            boolean[] path) {

        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(graph, neighbor, visited, path)) {
                    return true;
                }

            } else if (path[neighbor]) {

                return true;
            }
        }

        path[node] = false;

        return false;
    }

    public static void main(String[] args) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);

        System.out.println(
                "Contains cycle: "
                        + hasCycle(graph)
        );
    }
}