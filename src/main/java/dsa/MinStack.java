package main.java.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Demonstrates a stack that supports retrieving the minimum
 * element in O(1) time.
 *
 * <p>A second stack stores the minimum value at each level.
 *
 * <p>Time complexity: O(1) for push, pop, top, and getMin.
 * <br>Space complexity: O(n).
 */
public class MinStack {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int value) {

        stack.push(value);

        if (minStack.isEmpty()
                || value <= minStack.peek()) {

            minStack.push(value);
        }
    }

    public int pop() {

        int value = stack.pop();

        if (value == minStack.peek()) {
            minStack.pop();
        }

        return value;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Minimum: " + stack.getMin());

        stack.pop();

        System.out.println("Minimum after pop: "
                + stack.getMin());
    }
}