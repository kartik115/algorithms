package geeksdp.learning.kartikeya;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	public static int lis(int[] input) {
		int size = input.length;
		int[] arr = new int[size];
		Arrays.fill(arr, 1);
		int l = 1;
		for (int i=1; i<size; i++) {
			for(int j=0; j<i; j++) {
				if (input[i]>input[j] && arr[i] < arr[j] + 1) {
					arr[i] = arr[j]+1;
					l = Integer.max(arr[i], l);
				}
			}
		}
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split(" ");
		int[] input = new int[arr.length];
		for(int i=0; i< arr.length; i++) {
			input[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(lis(input));
	}

}
