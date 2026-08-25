package main.java.dsa;

import java.util.PriorityQueue;

/**
 * Demonstrates finding the Kth largest element using a min-heap.
 *
 * <p>The heap is kept at size k. The smallest value in the heap is
 * therefore the Kth largest value seen so far.
 *
 * <p>Time complexity: O(n log k)
 * <br>Space complexity: O(k)
 */
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 2;

        System.out.println(
                "Kth largest element: "
                        + findKthLargest(nums, k)
        );
    }
}