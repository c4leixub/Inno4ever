package com.zeetcode.aafb.array.sub;

/**
 * Input: [1,3,5,4,7] Output: 3
 * Explanation: The longest continuous increasing
 * subsequence is [1,3,5], its length is 3. Even though [1,3,5,7] is also an
 * increasing subsequence, it's not a continuous one where 5 and 7 are separated
 * by 4.
 */
public class LongestIncreaseSubarray {
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0)
			return 0;

		int max = 1, len = 1, i = 0;
		while (i < nums.length - 1) {
			if (nums[i] < nums[i + 1]) {
				len++;
			} else {
				max = Math.max(max, len);
				len = 1;
			}
			i++;
		}

		max = Math.max(max, len);
		return max;
	}
}
