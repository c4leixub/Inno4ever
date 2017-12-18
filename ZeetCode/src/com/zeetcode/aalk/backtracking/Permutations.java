package com.zeetcode.aalk.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return result;
		}
		permute(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
		return result;
	}
	private void permute(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
		if (nums.length == list.size()) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permute(nums, visited, list, result);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return result;
		}

		/* we need to sort the input array here because of this array
		 * contains the duplication value, then we need to skip the duplication
		 * value for the final result */
		Arrays.sort(nums);
		permuteUnique(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
		return result;
	}
	private void permuteUnique(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
		if (nums.length == list.size()) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permuteUnique(nums, visited, list, result);
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
