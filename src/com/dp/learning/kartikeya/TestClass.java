package com.dp.learning.kartikeya;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String inp = s.nextLine();
        int t = s.nextInt();
        s.nextLine();
        
        int[] lis = new int[n];
        int[] track = new int[n];
        Arrays.fill(track, -1);
        Arrays.fill(lis, 1);
        for (int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if (inp.charAt(j) < inp.charAt(i)){
                		if (lis[i] < lis[j]+1) {
                			lis[i] = lis[j] + 1;
                			track[i] = j;
                		}
                }
            }
        }
        for (int i=0;i <n; i++) {
        		System.out.print(lis[i] + "\t");
        }
        
        System.out.println();
        
        for (int i=0;i <n; i++) {
    			System.out.print(track[i] + "\t");
        }
        
        for (int i=0; i<t; i++){
            String query = s.nextLine();
            String[] arr = query.split(" ");
        }
        
        /*
         * 7
		   aabccae
		   3
		   2
		   1 6 d
		   2
         */

    }
}
