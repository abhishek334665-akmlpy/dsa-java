package main.java.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Demonstrates the Top K Elements pattern.
 *
 * <p>Finds the K most frequent elements in an integer array
 * using a frequency map and a min-heap.
 *
 * <p>Time complexity: O(n log k)
 * <br>Space complexity: O(n)
 */
public class TopKElements {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a.getValue(), b.getValue())
                );

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {

            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int[] result = topKFrequent(nums, 2);

        System.out.println("Top 2 frequent elements:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}