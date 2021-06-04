package com.twt.zoa.array;

import java.util.Stack;

/**
 * A shopkeeper needs to complete a sales task. He arranges the items for sale
 * in a row. 
 * 
 * Starting from the left, the shopkeeper subtracts the price of the
 * first lower or the same price item on the right side of the item from its
 * full price. 
 * 
 * If there is no item to the right that costs less than or equal to
 * the current item's price, the current item is sold at full price. You should
 * return the actual selling price of each item.
 * 
 * Input: Prices = [2, 3, 1, 2, 4, 2]	Output: [1, 2, 1, 0, 2, 2]
 * Explaination: [2-1, 3-1, 1, 2-2, 4-2, 2
 * 
 * Input: Prices = [1, 2, 3, 4, 5]	Output: [1, 2, 3, 4, 5]
 *
 */
public class FindDiscountedPrice {
	public int[] FinalDiscountedPrice(int[] prices) {
		int[] res = new int[prices.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			res[i] = prices[i];
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}

			while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
				int index = stack.pop();
				res[index] = prices[index] - prices[i];
			}

			stack.push(i);
		}

		return res;
	}
}
