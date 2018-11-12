package geeksdp.learning.kartikeya;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	
	static int minimumCoins(int[] coins, int totalCoins, int amount) {
		/*
		 * minCoins array to store min coins to get 0,1,2....amount
		 * coinUsedIndex is array to store index of coin used to get that amount
		 */
		int[] minCoins = new int[amount+1];
		Arrays.fill(minCoins, Integer.MAX_VALUE);
		minCoins[0] = 0;
		int[] coinUsedIndex = new int[amount+1];
		Arrays.fill(coinUsedIndex, -1);
		for (int i=0; i<totalCoins; i++) {
			for(int j=coins[i]; j<amount+1; j++) {
				if(minCoins[j] > 1 + minCoins[j-coins[i]] && minCoins[j-coins[i]] != Integer.MAX_VALUE) {
					minCoins[j] = 1 + minCoins[j-coins[i]];
					coinUsedIndex[j] = i;
				}
			}
		}
		
		System.out.println("coins used for minimum count : ");
		
		int index = amount;
		while(coinUsedIndex[index] != -1) {
			System.out.println(coins[coinUsedIndex[index]]);
			index = index - coins[coinUsedIndex[index]];
		}
		
		return minCoins[amount];
	}
	
	public static void main(String args[]) {
		/* test cases
		 4
		 7 2 3 6
		 13
		 Expected output: 
		 coins used for minimum count : 6 7
		 min coins used : 2
		 */
		Scanner sc = new Scanner(System.in);
		int totalCoins = sc.nextInt();
		int[] coins = new int[totalCoins];
		for (int i=0; i<totalCoins; i++) {
			coins[i] = sc.nextInt(); 
		}
		int amount = sc.nextInt();
		System.out.println("min coins used : " + minimumCoins(coins, totalCoins, amount));
	}
}
