package main.java.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Demonstrates the stack-based approach for validating parentheses.
 *
 * <p>Each opening bracket is pushed onto the stack. A closing bracket
 * must match the most recently opened bracket.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(n)
 */
public class ValidParentheses {

    public static boolean isValid(String input) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char open = stack.pop();

            if ((ch == ')' && open != '(')
                    || (ch == ']' && open != '[')
                    || (ch == '}' && open != '{')) {

                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("({[]})"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("((()))"));
    }
}