package main.java.dsa;

/**
 * Demonstrates reversing a singly linked list iteratively.
 *
 * <p>The algorithm changes each node's next reference so that the
 * direction of the list is reversed.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(1)
 */
public class ReverseLinkedList {

    private static class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    private static void printList(Node head) {

        Node current = head;

        while (current != null) {

            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original list:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed list:");
        printList(head);
    }
}