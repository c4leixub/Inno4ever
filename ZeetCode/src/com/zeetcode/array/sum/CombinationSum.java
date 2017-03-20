package com.zeetcode.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 */
public class CombinationSum {

	/**
	 * Each number can be use unlimited number of times.
	 */
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);

	    combinationSum1(candidates, target, 0, current, result);
		
		return result;
	}
	private void combinationSum1(int[] candidates, int target, int j,
			ArrayList<Integer> curr, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = j; i < candidates.length; i++) {
			if (target < candidates[i])
				return;

			curr.add(candidates[i]);
			combinationSum1(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);
		}
	}
	
	/**
	 * Each number in C may only be used once in the combination.
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);

		Set<List<Integer>> set = new HashSet<List<Integer>>();
	    combinationSum2(candidates, target, 0, current, set);
		
	    result.addAll(set);
		return result;
	}	
	private void combinationSum2(int[] candidates, int target, int j,
			ArrayList<Integer> curr, Set<List<Integer>> set) {
		if (target == 0) {
			set.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = j; i < candidates.length; i++) {
			if (target < candidates[i])
				return;

			curr.add(candidates[i]);
			combinationSum2(candidates, target - candidates[i], i+1, curr, set);
			curr.remove(curr.size() - 1);
		}
	}
	
	/**
	 * Find all possible combinations of k numbers that add up to a number n, 
	 * given that only numbers from 1 to 9 can be used and each combination 
	 * should be a unique set of numbers.
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();

	    combinationSum3(k, n, 1, current, result);
		
		return result;
	}
	private void combinationSum3(int k, int target, int j, ArrayList<Integer> curr, List<List<Integer>> result) {		
		if (curr.size() == k-1) {
			for (int i = j; i <= 9; i++) { 
				if (i == target) {
					List<Integer> t = new ArrayList<Integer>(curr);
					t.add(i);
					result.add(t);
					return;
				}
			}
		} else {
			for (int i = j; i <= 9; i++) {
				if (target < i)
					return;

				curr.add(i);
				combinationSum3(k, target - i, i+1, curr, result);
				curr.remove(curr.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> combinationSum4(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		ArrayList<Integer> current = new ArrayList<Integer>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
	    combinationSum4(n, 1, current, set);
	    result.addAll(set);
		return result;
	}
	private void combinationSum4(int target, int j,
			ArrayList<Integer> curr, Set<List<Integer>> set) {
		if (target == 0) {
			if (curr.size() > 1) {
				List<Integer> t = new ArrayList<Integer>(curr);
				set.add(t);
			}
			return;
		}
		
		for (int i = j; i <= target; i++) {
			curr.add(i);
			combinationSum4(target-i, 1, curr, set);
			curr.remove(curr.size() - 1);
		}
	}
	
	public List<List<Integer>> expression(int n, int startpos) { 
		List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
		if (n == 0) { 
			List<Integer> list = new ArrayList<Integer>(); 
			ret.add(list); 
			return ret; 
		} for (int i = startpos; i <= n; i++) { 
			List<List<Integer>> r = expression(n - i, i); 
			if (!r.isEmpty()) { 
				for (List<Integer> l : r) {
					l.add(0, i); 
					ret.add(l); 
				} 
			} 
		} 
		return ret;
	}

	public static void main(String[] args) {
		
		CombinationSum s = new CombinationSum();
		
		int[] candidate = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(s.combinationSum1(candidate, 8));
//		
		candidate = new int[] {10, 1, 2, 7, 6, 1, 5};
		System.out.println(s.combinationSum2(candidate, 8));
		
//		System.out.println(s.combinationSum3(10, 9));
		
		System.out.println(s.combinationSum4(3));
		
		System.out.println(s.expression(3, 1));
		
	}

}
