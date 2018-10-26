package tree.learning.kartikeya;

import java.util.ArrayList;
import java.util.List;

public class LCA {
	
	public Node findLca(Node node, int n1, int n2) {
		if (node==null) 
			return null;
		if (node.key==n1 || node.key==n2)
			return node;
		Node left_lca = findLca(node.left, n1, n2);
		Node right_lca = findLca(node.right, n1, n2);
		if (left_lca != null && right_lca != null)
			return node;
		return (left_lca != null) ? left_lca : right_lca;
	}
	
	public boolean getPath(Node node, int x, List<Integer> path) {
		if (node == null) 
			return false;
		path.add(node.key);
		if (node.key == x)
			return true;
		if (node.left != null && getPath(node.left, x, path)) {
			return true;
		}
		if (node.right != null && getPath(node.right, x, path)) {
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}
	
	static class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key = key;
			this.left = null;
			this.right  = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Let us create binary tree given in the above example 
        Node  root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8);
        LCA l = new LCA();
        System.out.println(l.findLca(root,4,5).key);
        
        List<Integer> path1 = new ArrayList<>(); 
        List<Integer> path2 = new ArrayList<>();
        System.out.println(l.getPath(root, 4, path1));
        System.out.println(l.getPath(root, 3, path2));
        int j = 0;
        for (int i = 0; i < path1.size() && j < path2.size(); i++) {
			if (path1.get(i) == path2.get(j)) {
				j = j + 1;
				continue;
			} else {
				break;
			}
		}
        
        int x = path1.size() - 1;
        while (x >= j) {
    			System.out.println(path1.get(x));
    			x -= 1;
        }
        
        x = j-1;
        while (x < path2.size()) {
        		System.out.println(path2.get(x));
        		x += 1;
        }
        
	}

}
