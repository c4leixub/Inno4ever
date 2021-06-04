package com.twt.zoa.dfs;

public class GetSetGo {
	
	public boolean hasSubSetSum(int[] nums, int target) {
		return this.hasSubSetSum(nums, 0, 0, target);
	}
	
	private boolean hasSubSetSum(int[] nums, int s, int sum, int target) {
		if (sum == target) {
			return true;
		}
		
		for (int i = s; i < nums.length; i++) {
			if (hasSubSetSum(nums, i + 1, sum + nums[i], target)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		GetSetGo g = new GetSetGo();
		
		int[] nums1 = { 2, 9, 5, 1, 6 };
		int target1 = 12;
		
		int[] nums2 = { 2, 3, 15, 1, 16 };
		int target2 = 8;
		
		System.out.println(g.hasSubSetSum(nums1, target1));
		System.out.println(g.hasSubSetSum(nums2, target2));
	}
}
