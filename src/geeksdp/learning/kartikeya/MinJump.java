package geeksdp.learning.kartikeya;
import java.util.*;

public class MinJump {
	/* test cases
	 11
	 1 3 5 8 9 2 6 7 6 8 9
	 Expected output 3 (->0->1->3->10)
	 10
	 1 3 6 3 2 3 6 8 9 5
	 Expected output 4 (->0->1->2->6->9)
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int last = 0;
		int[] jump = new int[n];
		int[] actual = new int[n];
		for(int i=1; i<n; i++) {
			jump[i] = Integer.MAX_VALUE;
			for(int j=0; j<i; j++) {
				if (j+arr[j] >= i && jump[i]>jump[j]+1) {
					jump[i] = jump[j]+1;
					actual[i] = j;
				}
			}
			//System.out.println(actual[i] +" "+ jump[i]);
		}
		System.out.println("minimum number of jumps: "+ jump[n-1]);
		int prev = jump[1];
		System.out.print("path to go to last index: ");
		// starting from index 1 because at index 0 there is no relevant info
		for(int i=2; i<n; i++) {
			if(prev!=jump[i]) {
				prev=jump[i];
				System.out.print("->"+ actual[i-1]);
			}
		}
		System.out.println("->"+ actual[n-1]+"->"+ (n-1));
	}
}
