package com.tree.learning.kartikeya;

public class BinaryTreeView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.print("top view of binary tree: ");
		tree.topView(tree.root);
		System.out.print("\nbottom view of binary tree: ");
		tree.bottomView(tree.root);
		System.out.print("\nleft view of binary tree: ");
		tree.leftView(tree.root);
		System.out.print("\nleft view of binary tree: ");
		tree.rightView(tree.root);
	}

}
