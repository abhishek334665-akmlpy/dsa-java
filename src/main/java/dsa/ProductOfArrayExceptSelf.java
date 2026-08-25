package main.java.dsa;

/**
 * Demonstrates the prefix/suffix product technique.
 *
 * <p>Returns an array where each element contains the product of all
 * input elements except the element at the same index.
 *
 * <p>The solution avoids division and uses constant auxiliary space
 * apart from the output array.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(1) excluding the result array.
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {

            result[i] = prefix;

            prefix *= nums[i];
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            result[i] *= suffix;

            suffix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}