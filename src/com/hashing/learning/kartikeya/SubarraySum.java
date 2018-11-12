package com.hashing.learning.kartikeya;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySum {
	
	/** max length of maximum sub array with 0 sum **/
	/** https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/  **/
	int maxLen(int arr[], int n)
    {
        // Your code here
        int sum_arr[] = new int[n];
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0 ; i < n; i++ ){
            sum += arr[i]; 
            sum_arr[i] = sum;
            if (max == 0 && arr[i] == 0) max = 1;
            if (sum == 0) max = i+1;
            if (hm.containsKey(sum)) {
                int l = hm.get(sum);
                if (i-l > max){
                    max = i-l;
                }
            } else {
                hm.put(sum, i);
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T>0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			SubarraySum obj = new SubarraySum();
			System.out.println(obj.maxLen(arr, n));
			T--;
		}
	}
}
