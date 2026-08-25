package main.java.dsa;

import java.util.HashSet;
import java.util.Set;

/**
 * Demonstrates the variable-size sliding window technique.
 *
 * <p>Finds the length of the longest substring containing
 * no repeated characters.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(n)
 */
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String input) {

        Set<Character> window = new HashSet<>();

        int left = 0;
        int maximumLength = 0;

        for (int right = 0; right < input.length(); right++) {

            char current = input.charAt(right);

            while (window.contains(current)) {

                window.remove(input.charAt(left));

                left++;
            }

            window.add(current);

            maximumLength = Math.max(
                    maximumLength,
                    right - left + 1
            );
        }

        return maximumLength;
    }

    public static void main(String[] args) {

        String input = "abcabcbb";

        System.out.println(
                "Longest substring length: "
                        + lengthOfLongestSubstring(input)
        );
    }
}