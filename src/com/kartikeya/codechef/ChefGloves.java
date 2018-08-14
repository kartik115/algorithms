package com.kartikeya.codechef;

import java.util.Scanner;

public class ChefGloves {
					 
	public static void main(String args[]) {
		//Scanner
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();               
	    while(t!=0) {
	    		t--;
	    		int n = s.nextInt();
	    		Boolean front = true, back = true;
	    		int fingures[] = new int[n];
	    		int gloves[] = new int[n];
	    		for(int i=0; i<n; i++) {
	    			fingures[i] = s.nextInt();
	    		}
	    		
	    		for(int i=0; i<n; i++) {
	    			gloves[i] = s.nextInt();
	    			
	    			if(!(fingures[n-1-i] <= gloves[i] && back)) {
	    				back = false;
	    			}
	    			
	    			if(!(fingures[i] <= gloves[i] && front)) {
	    				front = false;
	    			}
	    		}
	    		
	    		if(front && back) {
	    			System.out.println("both");
	    		}
	    		else if(front) {
	    			System.out.println("front");
	    		}
	    		else if(back) {
	    			System.out.println("back");
	    		}
	    		else {
	    			System.out.println("none");
	    		}
	    }
	}
}
