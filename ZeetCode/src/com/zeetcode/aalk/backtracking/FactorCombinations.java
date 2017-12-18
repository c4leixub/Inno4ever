package com.zeetcode.aalk.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * a function that takes an integer n and return all possible combinations of
 * its factors.
 * 
 * Note: You may assume that n is always positive. Factors should be greater
 * than 1 and less than n.
 */
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n == 1) {
			return result;
		}

		getFactors(2, 1, n, new ArrayList<Integer>(), result);
		return result;
	}

	public void getFactors(int start, int product, int n, List<Integer> list, List<List<Integer>> result) {
		if (product == n) {
			List<Integer> t = new ArrayList<Integer>(list);
			result.add(t);
			return;
		}

		for (int i = start; i < n; i++) {
			if (product * i > n) {
				break; // the rest of i will have the same condition
			}

			if (n % (product * i) == 0) {
				list.add(i);
				getFactors(i, product * i, n, list, result);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		FactorCombinations f = new FactorCombinations();
		System.out.println(f.getFactors(4));
	}
}
