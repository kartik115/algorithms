package com.dp.learning.kartikeya;

import java.util.Scanner;

public class EggDropping {
	public static void main(String[] args) {
		int floors;
		int eggs;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0) {
			eggs = sc.nextInt();
			floors = sc.nextInt();
			find_minimum_attempts(eggs, floors);
			t--;
		}
		
	}

	private static void find_minimum_attempts(int eggs, int floors) {
		// TODO Auto-generated method stub
		int[][] result = new int[eggs+1][floors+1];
		
		for (int i=0; i <= eggs; i++) {
			result[i][0] = 0;
		}
		
		for(int j=0; j <= floors; j++) {
			result[1][j] = j;
			result[0][j] = 0;
		}
		
		for (int i=2; i<=eggs; i++) {
			for (int j=1; j<=floors; j++) {
				if (i>j) {
					result[i][j] = result[i-1][j];
				}
				else {
					result[i][j] = Integer.MAX_VALUE;
					for(int k=1; k<=j; k++) {
						result[i][j] = Integer.min( result[i][j], (1 + Integer.max(result[i-1][k-1], result[i][j-k])) );
					}
				}
				// System.out.print(result[i][j]+"\t");
			}
			// System.out.println();
		}
		
		System.out.println(result[eggs][floors]);
	}
}
