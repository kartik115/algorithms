package com.codechef.kartikeya;

class StaticTest { 
    static final int i; 
    int j; 
    static { 
        i = 10; 
        System.out.println("static block called "); 
    } 
    StaticTest(){
        System.out.println("Constructor called" + i); 
    } 
} 
  
class Test { 
    public static void main(String args[]) { 
       // Although we have two objects, static block is executed only once. 
    		StaticTest t1 = new StaticTest(); 
    		StaticTest t2 = new StaticTest(); 
    } 
} 
