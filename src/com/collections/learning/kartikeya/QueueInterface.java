package com.collections.learning.kartikeya;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueInterface {
	public static void main(String[] args) {
		Queue<String> q1 = new ArrayDeque<String>();
		Deque<String> q2 = new ArrayDeque<String>();
		PriorityQueue<String> q3 = new PriorityQueue<String>();
		
		
		/**
		 * Array dequeue
		 */
		q1.add("Virat");
		q1.add("Rohit");
		q1.add("Dhawan");
		System.out.println(q1.peek());
		System.out.println("polling : "+ q1.poll() +" "+ q1.poll());
		
		q2.push("Bumrah");
		q2.push("Bhuvneshwar");
		q2.push("Kuldeep");
		System.out.println(q2.pop());
		
	}
}
