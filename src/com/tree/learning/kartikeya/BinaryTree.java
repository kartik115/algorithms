package com.tree.learning.kartikeya;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

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
	
	public void topView(Node node) {
		
		if (node == null)
			return ;
		
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> map = new TreeMap<Integer, Node>(); 
		QueueObj n = new QueueObj(node, 0);
		q.add(n);
		
		while (!q.isEmpty()) { 
            QueueObj tmpNode = q.poll(); 
            if (!map.containsKey(tmpNode.level)) { 
                map.put(tmpNode.level, tmpNode.node); 
            } 
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.level - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.level + 1)); 
            } 
  
        } 
        for (Entry<Integer, Node> entry : map.entrySet()) { 
            System.out.print(entry.getValue().value); 
        } 
	}
	
	public void bottomView(Node node) { 
		
		if (node == null)
			return ;
		
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> map = new TreeMap<Integer, Node>();
		QueueObj n = new QueueObj(node, 0);
		q.add(n);
		
		while (!q.isEmpty()) { 
            QueueObj tmpNode = q.poll(); 
            map.put(tmpNode.level, tmpNode.node);
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.level - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.level + 1)); 
            } 
  
        } 
        for (Entry<Integer, Node> entry : map.entrySet()) { 
            System.out.print(entry.getValue().value); 
        }
	}
	
	public void rightView(Node node) {
		if (node == null)
			return ;
	}
	
	public void leftView(Node node) {
		if (node == null)
			return ;
	}
}
