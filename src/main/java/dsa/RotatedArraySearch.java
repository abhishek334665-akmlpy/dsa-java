package main.java.dsa;

/**
 * Demonstrates binary search on a rotated sorted array.
 *
 * <p>At every step, at least one half of the array is guaranteed
 * to be sorted. The target is then checked against that sorted half.
 *
 * <p>Time complexity: O(log n)
 * <br>Space complexity: O(1)
 */
public class RotatedArraySearch {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // Left half is sorted.
            if (nums[left] <= nums[middle]) {

                if (target >= nums[left]
                        && target < nums[middle]) {

                    right = middle - 1;

                } else {

                    left = middle + 1;
                }

            } else {

                // Right half is sorted.
                if (target > nums[middle]
                        && target <= nums[right]) {

                    left = middle + 1;

                } else {

                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int target = 0;

        System.out.println(
                "Target index: "
                        + search(nums, target)
        );
    }
}