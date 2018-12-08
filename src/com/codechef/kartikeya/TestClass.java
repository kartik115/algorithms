package com.codechef.kartikeya;

class Base {
	static void display() {
		System.out.println("Static or class method from Base");
	}
	private void print() {
		System.out.println("Non-static or instance method from Base");
	}
}

class Derived extends Base {
	static void display() {
		System.out.println("Static or class method from Derived");
	}
	private void print() {
		System.out.println("Non-static or instance method from Derived");
	}
}

public class TestClass {
	public static void main(String args[])
	{
		Base obj = new Derived();
		obj.display();
	}
}
