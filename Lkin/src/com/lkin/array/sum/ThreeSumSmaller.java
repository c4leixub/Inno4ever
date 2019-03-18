package com.lkin.array.sum;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:
 */
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3)    return 0;
        
        Arrays.sort(nums);
        
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            int t = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < t) {
                    count += (k-j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return count;
    }
}
