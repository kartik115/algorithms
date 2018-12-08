package com.multithreading.kartikeya;

import java.util.concurrent.atomic.AtomicLong;

class Even extends Thread{
	AtomicLong num;
	Object lock;
	
	Even(AtomicLong num, Object lock) {
		this.num = num;
		this.lock = lock;
	}
	
	public void run() {
		synchronized (lock) {
			while(true) {
				if (num.get() % 2 != 0) {
					try {
//						System.out.println("even waiting" + num);
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("even: "+ num);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					num.incrementAndGet();
					lock.notifyAll();
				}
			}
		}
	}
}

class Odd extends Thread {
	AtomicLong num;
	Object lock;
	
	Odd(AtomicLong num, Object lock) {
		this.num = num;
		this.lock = lock;
	}
	
	public void run() {
		synchronized (lock) {
			while(true) {
				if (num.get() % 2 != 1) {
					try {
//						System.out.println("odd lock :" + num);
						lock.wait();
//						System.out.println("odd lock released : " + num);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("odd: "+ num);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					num.incrementAndGet();
					lock.notifyAll();
				}
			}
		}
	}
}

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicLong num = new AtomicLong(1);
		Object lock = new Object();
		Even e = new Even(num, lock);
		Odd o = new Odd(num, lock);
		e.start();
		o.start();
	}

}
