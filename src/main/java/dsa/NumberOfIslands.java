package main.java.dsa;

/**
 * Demonstrates DFS for finding the number of islands in a grid.
 *
 * <p>An island is a group of connected land cells represented by
 * {@code '1'}. Each time an unvisited land cell is found, DFS marks
 * the complete island as visited.
 *
 * <p>Time complexity: O(rows * columns)
 * <br>Space complexity: O(rows * columns) in the worst case
 * due to the recursion stack.
 */
public class NumberOfIslands {

    public static int countIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int row = 0; row < grid.length; row++) {

            for (int column = 0;
                 column < grid[row].length;
                 column++) {

                if (grid[row][column] == '1') {

                    count++;

                    dfs(grid, row, column);
                }
            }
        }

        return count;
    }

    private static void dfs(
            char[][] grid,
            int row,
            int column) {

        if (row < 0
                || row >= grid.length
                || column < 0
                || column >= grid[row].length
                || grid[row][column] != '1') {

            return;
        }

        grid[row][column] = '0';

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(
                "Number of islands: "
                        + countIslands(grid)
        );
    }
}