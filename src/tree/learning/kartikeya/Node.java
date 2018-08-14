package tree.learning.kartikeya;

public class Node {
	int value;
	Node right, left;
	
	public Node(int value) {
		this.value = value;
		this.left = this.right = null;
	}
}
