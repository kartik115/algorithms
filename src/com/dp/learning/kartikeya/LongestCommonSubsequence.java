package com.dp.learning.kartikeya;

import java.util.Scanner;
import java.util.Stack;

public class LongestCommonSubsequence {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(longest_common_subsequence(a,b));
	}

	private static int longest_common_subsequence(String a, String b) {
		// TODO Auto-generated method stub
		int len = 0;
		int row = a.length();
		int col = b.length();
		int[][] result = new int[row+1][col+1];
		int x = -1;
		int y = -1;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					result[i+1][j+1] = result[i][j] + 1;
					if (len < result[i+1][j+1]) {
						len = result[i+1][j+1];
						x = i+1;
						y = j+1;
					}
					
				} else {
					result[i+1][j+1] = (result[i+1][j] > result[i][j+1]) ? result[i+1][j] : result[i][j+1];
				}
			}
		}
		print_longest_common_subsequence(result, len, x, y, a);
		System.out.println("\nlength of common subsequence");
		return len;
	}

	private static void print_longest_common_subsequence(int[][] result, int len, int x, int y, String a) {
		
		Stack<Character> c = new Stack<Character>();
		int t = len;
		System.out.println("printing common subsequence");
		while (t > 0 && x > 0 && y >0) {
			if (result[x][y] == result[x-1][y-1] + 1) {
				c.push(a.charAt(x-1));
				t = t-1;
				x = x-1;
				y = y-1;
			} else if (result[x][y] == result[x-1][y]) {
				x = x-1;
			} else if (result[x][y] == result[x][y-1]) {
				y = y-1;
			}
		}
		
		while(!c.isEmpty()) {
			System.out.print(c.pop());
		}
	}
}
