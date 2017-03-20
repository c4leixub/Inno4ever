package com.zeetcode.dynamicprogramming;

import com.zeetcode.node.TreeNode;

/**
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
	}

	// first house is neighbor of the last house
	public int robCircular(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int max1 = robCircularHelper(nums, 0, nums.length - 2);
		int max2 = robCircularHelper(nums, 1, nums.length - 1);

		return Math.max(max1, max2);
	}
	public int robCircularHelper(int[] nums, int i, int j) {
		if (i == j) {
			return nums[i];
		}

		int[] dp = new int[nums.length];
		dp[i] = nums[i];
		dp[i + 1] = Math.max(nums[i + 1], dp[i]);

		for (int k = i + 2; k <= j; k++) {
			dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
		}

		return dp[j];
	}
	
	// house is become like a tree
	public int rob(TreeNode root) {
	    if(root == null)
	        return 0;
	 
	    int[] result = helper(root);
	    return Math.max(result[0], result[1]);
	} 
	public int[] helper(TreeNode root){
	    if(root == null){
	        int[] result = {0, 0};
	        return result;
	    }
	 
	    int[] result = new int[2];
	    int[] left = helper(root.left);
	    int[] right = helper (root.right);
	 
	    // result[0] is when root is selected, result[1] is when not. 
	    result[0] = root.val + left[1] + right[1];
	    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	 
	    return result;
	}
}
