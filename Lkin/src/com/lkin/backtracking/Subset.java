package com.lkin.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	
	/**
	 * Given a set of distinct integers, S, return all possible subsets.
	 */
	public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), nums, 0);
        
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> tmp, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(tmp));
        
        for (int i = pos; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(result, tmp, nums, i+1);
            tmp.remove(tmp.size()-1); 
        }
    }

	/**
	 * Given a collection of integers that might contain duplicates, num, return all
	 * possible subsets.
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs2(result, new ArrayList<Integer>(), nums, 0);

		return result;
	}
	private void dfs2(List<List<Integer>> result, List<Integer> tmp, int[] nums, int pos) {
		result.add(new ArrayList<Integer>(tmp));

		for (int i = pos; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs2(result, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);

			// ignore duplicates
			while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}
}
