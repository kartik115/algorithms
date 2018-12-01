package com.multithreading.kartikeya;

public class MultiThreadingDemo extends Thread{
	public void run() {
		System.out.println("thread is running....");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadingDemo t1 = new MultiThreadingDemo();
		t1.start();
		
		MutliRunnable m = new MutliRunnable();
		Thread t2 = new Thread(m);
		t2.start();
	}

}

class MutliRunnable implements Runnable{
	public void run(){  
		System.out.println("thread is running...");  
	}
}