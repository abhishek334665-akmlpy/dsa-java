package main.java.dsa;

/**
 * Demonstrates searching for a value in a matrix where each row
 * and each column is sorted in ascending order.
 *
 * <p>The search starts at the top-right corner. Moving left
 * eliminates larger values, while moving down eliminates
 * smaller values.
 *
 * <p>Time complexity: O(rows + columns).
 * <br>Space complexity: O(1).
 */
public class SearchInSortedMatrix {

    public static boolean search(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {

            int value = matrix[row][column];

            if (value == target) {
                return true;
            }

            if (value > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        System.out.println("Found 5: "
                + search(matrix, 5));

        System.out.println("Found 15: "
                + search(matrix, 15));
    }
}