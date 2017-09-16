package com.zeetcode.dynamicprogramming;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:	coins = [1, 2, 5], amount = 11	return 3 (11 = 5 + 5 + 1)
Example 2:	coins = [2], amount = 3	return -1.
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        int d[] = new int[amount+1];
        d[0] = 0;
        
        for (int amt = 1; amt < amount+1; amt++) {
            d[amt] = Integer.MAX_VALUE;
            
            for (int coin : coins) {
                 if (amt >= coin && d[amt - coin] != Integer.MAX_VALUE) {
                     d[amt] = Math.min(d[amt], d[amt - coin] + 1);
                 }   
            }
        }
        
        return d[amount] == Integer.MAX_VALUE ? -1 : d[amount];
    }
}
