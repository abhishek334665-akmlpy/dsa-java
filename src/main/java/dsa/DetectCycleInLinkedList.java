package main.java.dsa;

/**
 * Demonstrates Floyd's Cycle Detection Algorithm.
 *
 * <p>A slow pointer moves one step at a time while a fast pointer
 * moves two steps. If they meet, the linked list contains a cycle.
 *
 * <p>Time complexity: O(n).
 * <br>Space complexity: O(1).
 */
public class DetectCycleInLinkedList {

    private static class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle.
        fourth.next = second;

        System.out.println(
                "Contains cycle: "
                        + hasCycle(first)
        );
    }
}