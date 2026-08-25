package main.java.dsa;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Demonstrates level-order traversal of a binary tree using BFS.
 *
 * <p>Nodes are processed level by level using a queue.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(n)
 */
public class BinaryTreeLevelOrderTraversal {

    private static class Node {

        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                Node current = queue.poll();

                System.out.print(current.value + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level-order traversal:");

        levelOrder(root);
    }
}