package com.string.learning.kartikeya;

public class TestStringBuffer {
	StringBuffer sbuff = new StringBuffer();
	
	/**
	 * synchronized
	 * @param s
	 */
	void concatBuffer(String s) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbuff.append(s);
		System.out.println(Thread.currentThread().getName() + "---->"+ sbuff);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStringBuffer ts = new TestStringBuffer();
		
		Thread t1 = new Thread() {
			public void run() {
				ts.concatBuffer(" first ");		
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				ts.concatBuffer(" second ");	
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				ts.concatBuffer(" third ");	
			}
		};
		
		Thread t4 = new Thread() {
			public void run() {
				ts.concatBuffer(" fourth ");		
			}
		};
		
		Thread t5 = new Thread() {
			public void run() {
				ts.concatBuffer(" fifth ");	
			}
		};
		
		Thread t6 = new Thread() {
			public void run() {
				ts.concatBuffer(" sixth ");	
			}
		};
		
		t1.setName("Buffer-1");
		t2.setName("Buffer-2");
		t3.setName("Buffer-3");
		t4.setName("Buffer-4");
		t5.setName("Buffer-5");
		t6.setName("Buffer-6");
		
		t4.start();
		t5.start();
		t6.start();
		t1.start();
		t2.start();
		t3.start();
		
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
		System.out.println("data loss won't be there --->" + ts.sbuff);
	}

}
