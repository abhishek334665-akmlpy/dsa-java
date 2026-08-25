/**
 * Demonstrates recursive inorder traversal of a binary tree.
 *
 * <p>Inorder traversal visits the left subtree, the current node,
 * and then the right subtree.
 *
 * <p>Time complexity: O(n)
 * <br>Space complexity: O(h), where h is the tree height.
 */

package dsa;

/** Simple binary-tree node used by the traversal example. */
class Node {

	int data;
	Node left, right;

	/** Creates a node containing the supplied value. */
	Node(int data) {
		this.data = data;
	}
}

public class TreeTraversal {

	static void inorder(Node root) {

		if (root == null)
			return;

		inorder(root.left);

		System.out.print(root.data + " ");

		inorder(root.right);
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		Node root1 = new Node(50);
		root1.left = new Node(40);
		root1.right = new Node(30);
		Node root2 = new Node(100);
		root2.left = root;
		root2.right =root1;
		

		inorder(root2);
	}
}