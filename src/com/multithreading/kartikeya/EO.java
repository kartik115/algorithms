package com.multithreading.kartikeya;

public class EO extends Thread {
	
	int count = 0;
	boolean running = false;
	
	synchronized void printEven() throws InterruptedException {
		if(!running) {
			if(count % 2 == 0) {
				System.out.println("Even: "+ count);
				Thread.sleep(10);
				wait();
			}
		}
		running = false;
		count++;
		notify();
	}
	
	synchronized void printOdd() throws InterruptedException {
		if(running) {
			if(count % 2 == 1) {
				System.out.println("odd: "+ count);
				Thread.sleep(10);
				wait();
			}
		}
		running = true;
		count++;
		notify();
	}
	
	public static void main(String[] args) {
		EO eo = new EO();
	
		Thread even = new Thread() {
			public void run() {
				while (true) {
					try {
						eo.printEven();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	
		Thread odd = new Thread() {
			public void run() {
				while (true) {
					try {
						eo.printOdd();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		even.start();
		odd.start();
	
	}
}
