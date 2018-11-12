package com.tree.learning.kartikeya;

public class BinaryTreeTraversal {
	
	public static void main(String args[]) {
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("Level order traversal");
		tree.levelOrderTraversal(tree);
		System.out.println("\nIn order traversal");
		tree.inOrderTraversal(tree.root);
		System.out.println("\nPre order traversal");
		tree.preOrderTraversal(tree.root);
		System.out.println("\nPost order traversal");
		tree.postOrderTraversal(tree.root);
	}
	
}
