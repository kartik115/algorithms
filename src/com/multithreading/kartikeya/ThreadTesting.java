package com.multithreading.kartikeya;


public class ThreadTesting extends Thread {
	public void run(){  
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + Thread.currentThread().getName() + " " +Thread.currentThread().getPriority()); 
		}
	}
	public static void main(String args[]){  
		ThreadTesting t = new ThreadTesting();
		ThreadTesting t1 = new ThreadTesting();
		ThreadTesting t2 = new ThreadTesting();
		ThreadTesting t3 = new ThreadTesting();
		t1.setPriority(MIN_PRIORITY);
		t.start();
//		System.out.println(t.getPriority());
//		System.out.println(t.getName());
		t1.start();
//		System.out.println(t1.getPriority());
//		System.out.println(t1.getName());
		t2.start();
//		System.out.println(t2.getPriority());
//		System.out.println(t2.getName());
//		t3.start();
	}
}
