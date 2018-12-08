package com.string.learning.kartikeya;

public class TestStringBuilder extends Thread{
	StringBuilder sbuild = new StringBuilder();
	
	/**
	 * not synchronised
	 * @param s
	 */
	void concatBuilder(String s) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbuild.append(s);
		System.out.println(Thread.currentThread().getName() + "---->" +sbuild);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStringBuilder ts = new TestStringBuilder();
		
		Thread t1 = new Thread() {
			public void run() {
				ts.concatBuilder(" first ");		
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				ts.concatBuilder(" second ");	
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				ts.concatBuilder(" third ");	
			}
		};
		
		Thread t4 = new Thread() {
			public void run() {
				ts.concatBuilder(" fourth ");		
			}
		};
		
		Thread t5 = new Thread() {
			public void run() {
				ts.concatBuilder(" fifth ");	
			}
		};
		
		Thread t6 = new Thread() {
			public void run() {
				ts.concatBuilder(" sixth ");	
			}
		};
		
		t1.setName("Builder-1");
		t2.setName("Builder-2");
		t3.setName("Builder-3");
		t4.setName("Builder-4");
		t5.setName("Builder-5");
		t6.setName("Builder-6");
		
		t4.start();
		t5.start();
		t1.start();
		t2.start();
		t3.start();
		t6.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("there might occur data loss ----> " + ts.sbuild);
	}
}
