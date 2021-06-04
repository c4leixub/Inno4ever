package com.fcb.design;

import java.util.HashMap;
import java.util.Map;

public class ApplyDiscountEveryNthOrder {

	class Cashier {

		private int n;
		private int count;
		private int discount;
		
		private Map<Integer, Integer> productIdToUnitPrice;

//		private int maxId;
//		private int[] idToPrice;

		public Cashier(int n, int discount, int[] products, int[] prices) {
			this.n = n;
			this.count = 0;
			this.discount = discount;
			
			init(products, prices);	// better to move this getBill
		}
		
		private void init(int[] products, int[] prices) {
			productIdToUnitPrice = new HashMap<Integer, Integer>();
			for (int i = 0; i < products.length; i++) {
				productIdToUnitPrice.put(products[i], prices[i]);
			}
			
			// array access has better performance
			
//			maxId = Integer.MIN_VALUE;
//		    for (int i = 0; i < products.length; i++) {
//	            maxId = Math.max(maxId, products[i]);
//		    }
//
//	        idToPrice = new int[maxId+1];
//	        for (int i = 0; i < products.length; i++) {
//	            idToPrice[products[i]] = prices[i];
//	        }
		}

		public double getBill(int[] product, int[] amount) {
			double cost = 0.0;
			for (int i = 0; i < product.length; i++) {
				cost += (productIdToUnitPrice.get(product[i]) * amount[i]);
				// cost += idToPrice[product[i]] * amount[i];
			}

			this.count += 1;
			if (this.count % n == 0) {
				cost -= (discount * cost) / 100.0;
			}

			return cost;
		}
	}
}
