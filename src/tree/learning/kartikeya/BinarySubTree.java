package tree.learning.kartikeya;

public class BinarySubTree {
	
	public static Boolean identical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return (root1.value == root2.value && identical(root1.left, root2.left) && identical(root1.right, root2.right));
	}
	
	public static Boolean isSubtree(Node root1, Node root2) {
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if (identical(root1, root2))
			return true;
		return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
	}
	
	public static void main(String args[]) {
		
		BinaryTree t1, t2;
		t1 = new BinaryTree();
		t1.root = new Node(1);
		t1.root.left = new Node(2);
		t1.root.right = new Node(3);
		t1.root.left.left = new Node(4);
		t1.root.left.right = new Node(5);
		
		t2 = new BinaryTree();
		t2.root = new Node(5);
		t2.root.left = new Node(6);
		t2.root.right = new Node(7);
		t2.root.left.left = new Node(1);
		t2.root.left.right = new Node(8);
		t2.root.right.left = new Node(9);
		t2.root.right.right = new Node(10);
		t2.root.left.left.left = new Node(2);
		t2.root.left.left.right = new Node(3);
		t2.root.right.left.left = new Node(11);
		t2.root.right.left.right = new Node(12);
		t2.root.left.left.left.left = new Node(4);
		t2.root.left.left.left.right = new Node(5);
		//t2.root.left.left.left.right.left = new Node(6);
		//t1.levelOrderTraversal(t1);
		System.out.println(isSubtree(t2.root, t1.root));
		//t2.levelOrderTraversal(t2);
	}
	
}
