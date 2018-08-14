package tree.learning.kartikeya;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int value) {
		root = new Node(value);
	}
	
	public void inOrderTraversal(Node node) {
		if (node == null)
			return ;
		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}
	
	public void preOrderTraversal(Node node) {
		if (node == null)
			return ;
		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public void postOrderTraversal(Node node) {
		if (node == null)
			return ;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}
	
	public void levelOrderTraversal(BinaryTree tree) {
		Queue<Node> queue = new LinkedList<>();;
		queue.add(tree.root);
		Node curr = tree.root;
		while(queue.size()!=0) {
			curr = queue.remove();
			System.out.print(curr.value+ " ");
			if(curr.left!=null)
				queue.add(curr.left);
			if (curr.right!=null)
				queue.add(curr.right);
		}
	}
}
