package com.collections.learning.kartikeya;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ListInterface {
	public static void main(String[] args) {
		List<Integer> l1= new ArrayList<Integer>();
		Vector<Integer> l2= new Vector<Integer>();
		Stack<String> l3= new Stack<String>();
		LinkedList<String> l4= new LinkedList<String>();
		
		/**
		 * array list implementation
		 */
		System.out.println("******** Arraylist implementation *******");
		l1.add(1);
		l1.add(2);
		l1.add(1, 3);
		Iterator<Integer> itr1 = l1.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		
		/**
		 * vector implementation
		 */
		System.out.println("********* Vector implementation *********");
		l2.add(101);
		l2.add(102);
		l2.insertElementAt(105, 0);
		l2.addElement(104);
		
		Iterator<Integer> itr2 = l2.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		/**
		 * Stack implementation
		 */
		System.out.println("****** Stack implementation *******");
		l3.push("Amit");
		l3.push("Abhinav");
		l3.add("Kartikeya");
		l3.add("Aman");
		while (!l3.isEmpty()) {
			System.out.println(l3.pop());
		}
		
		/**
		 * LinkedList implementation
		 */
		System.out.println("******* Linklist implementation ******");
		l4.add("Avnish");
		l4.addFirst("Samrat");
		l4.addLast("Ganesh CTO");
		l4.add(2, "Ganesh CEO");
		l4.add("Mahender");
		while(!l4.isEmpty()) {
			System.out.println("Remove: " + l4.remove());
			System.out.println("Remove First: "+ l4.removeFirst());
			System.out.println("Get Last: " + l4.getLast() +" & Get First: " +l4.getFirst());
			l4.clear();
		}
	}
}
