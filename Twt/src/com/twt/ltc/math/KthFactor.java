package com.twt.ltc.math;

import java.util.ArrayList;
import java.util.List;

public class KthFactor {
	public int kthFactor(int n, int k) {
		int i = 0, j = 1;
		while (i < k && j <= n / 2) {
			if (n % j == 0) {
				i++;
				if (i == k) {
					return j;
				}
			}
			j++;
		}

		if (i + 1 == k) {
			return n;
		}

		return -1;
	}

	// Time: O(sqrt(n)), Space: O(min(k, sqrt(n)), the space to store divisor
	public int kthFactorBetter(int n, int k) {
		List<Integer> divisors = new ArrayList<>();
		int sqrt = (int) Math.sqrt(n);
		int j = 1;
		while (j < sqrt + 1) {
			if (n % j == 0) {
				k--;
				divisors.add(j);
				if (k == 0) {
					return j;
				}
			}
			j++;
		}

		// handle perfect square
		if (sqrt * sqrt == n) {
			k++;
		}

		int divSize = divisors.size();
		return (k <= divSize) ? n / divisors.get(divSize - k) : -1;

	}
}
