package com.abb.abb;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Input: A = [x1, x2, ..., xn]
 * Sum T = Round(x1+x2+... +xn)
 * Output: B = [y1, y2, ...., yn], yi = floor(xi) or ceiling(xi)
 * 
 * Constraint #1: y1+y2+...+yn = T
 * Constraint #2: minimize sum(abs(diff(xi - yi)))
 * 
 * example: 
 * A = [1.2, 2.3, 3.4]
 * Round(1.2 + 2.3 + 3.4) = 6.9 => 7
 * 
 * 1 + 2 + 3 => 6
 * 0.2 + 0.3 + 0.4 = 1.0
 * 
 * 1 + 3 + 3 => 7
 * 0.2 + 0.7 + 0.4 = 1.3
 * 
 * 1 + 2 + 4 => 7
 * 0.2 + 0.3 + 0.6 = 1.1
 * 
 * {1,2,4} is better than {1,3,3}
 */
public class RoundPrice {

	class NumWithDiff {
		int ceil;
		double diffWithCeil;

		public NumWithDiff(int n, double c) {
			this.ceil = n;
			this.diffWithCeil = c;
		}
	}

	public int[] roundUp(double[] arr) {
		int n = arr.length;
		NumWithDiff[] arrWithDiff = new NumWithDiff[n];

		double sum = 0.0;
		int floorSum = 0;
		for (int i = 0; i < n; i++) {
			int floor = (int) arr[i];
			int ceil = floor < arr[i] ? floor + 1 : floor;

			floorSum += floor;
			sum += arr[i];
			arrWithDiff[i] = new NumWithDiff(ceil, ceil - arr[i]);
		}

		int num = (int) Math.round(sum);
		int diff = num - floorSum;
		Arrays.sort(arrWithDiff, new Comparator<NumWithDiff>() {
			@Override
			public int compare(NumWithDiff n1, NumWithDiff n2) {
				if (n1.diffWithCeil <= n2.diffWithCeil)	return -1;
				
				return 1;
			}
		});
		
		int[] res = new int[n];
		int i = 0;
		while (i < diff) {	// use ceil
			res[i] = arrWithDiff[i].ceil; 
			i++;
		}
		while (i < n) {	// the rest use floor
			res[i] = arrWithDiff[i].ceil-1;	
			i++;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		RoundPrice rp = new RoundPrice();
		double[] input = new double[] {1.2,2.3,3.4};
		for (int r : rp.roundUp(input)) {
			System.out.println(r + " ");
		}
	}
}
