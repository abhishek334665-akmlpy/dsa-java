package main.java.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates backtracking for the Combination Sum problem.
 *
 * <p>The algorithm explores possible combinations recursively.
 * A candidate can be selected multiple times as long as the
 * remaining target allows it.
 *
 * <p>Time complexity: exponential in the worst case.
 * <br>Space complexity: O(target) for the recursion depth,
 * excluding the returned combinations.
 */
public class CombinationSum {

    public static List<List<Integer>> findCombinations(
            int[] candidates,
            int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        if (remaining == 0) {

            result.add(new ArrayList<>(current));

            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            int candidate = candidates[i];

            if (candidate > remaining) {
                continue;
            }

            current.add(candidate);

            // Use i again because a candidate may be reused.
            backtrack(
                    candidates,
                    remaining - candidate,
                    i,
                    current,
                    result
            );

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};

        int target = 7;

        List<List<Integer>> result =
                findCombinations(candidates, target);

        System.out.println("Combinations:");

        result.forEach(System.out::println);
    }
}