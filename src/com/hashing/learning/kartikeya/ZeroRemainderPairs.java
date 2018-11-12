package com.hashing.learning.kartikeya;

import java.util.HashMap;
import java.util.Scanner;

public class ZeroRemainderPairs {
	
	/* Check if an array can be divided into pairs whose sum is divisible by k */
    /* https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/ */
	private static boolean findPairs(int arr[], int k, int n) {
		int len = n;
		if (len % 2 == 1) return false;
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < len; i++) {
			int key = arr[i] % k;
			arr[i] = key;
			if (hm.containsKey(key)) {
				hm.put(key, hm.get(key)+ 1);
			}
			else {
				hm.put(key, 1);
			}
			// System.out.println(key);
			// System.out.println( hm.get(key) );
		}
		
		for (int i = 0; i < len; i++) {
			int a = arr[i];
			if (2*a == k) {
				if (hm.get(a) % 2 == 1) {
					// System.out.println("1 "+a);
					return false;
				}
			} else if (a == 0) {
				if (hm.get(a) % 2 == 1) {
					// System.out.println("2: "+ a);
					return false;
				}
			} else {
				if (!hm.containsKey(k-a)) {
					// System.out.println("3: "+ a);
					return false;
				}
				else {
				    if(hm.get(a) != hm.get(k-a)){
				        return false;
				    }
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0) {
        		int n = in.nextInt();
        		int arr[] = new int[n];
        		for (int i = 0; i < n ; i++) {
        			arr[i] = in.nextInt();
        		}
        		int k = in.nextInt();
        		t = t - 1;
        		boolean output = findPairs(arr, k, n);
        		System.out.println(output);
        }
	}
	
}
