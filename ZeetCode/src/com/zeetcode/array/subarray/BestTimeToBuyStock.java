package com.zeetcode.array.subarray;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 */
public class BestTimeToBuyStock {

	/**
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * Assume prices[i] >= 0, maximize prices[j]-prices[i] which means price[i]
	 * is the min and price[j] is the max
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int min = prices[0]; // min so far
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}

		return profit;
	}

	/**
	 * Design an algorithm to find the maximum profit by complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * This problem can be viewed as finding all ascending sequences.
	 */
	public int maxProfit2(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}

		return profit;
	}
	
	public int maxProfitCoolDown(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}

		return profit;
	}
}
