package com.lkin.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;

			list.add(nums[i]);
			visited[i] = true;
			dfs(result, list, nums, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		permuteUnique(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return result;
	}

	private void permuteUnique(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permuteUnique(result, list, nums, visited);
				visited[i] = false;
				list.remove(list.size() - 1);

				// we use this while loop to skip the duplication value in the
				// input array.
				while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
					i++;
				}
			}
		}

	}
}
