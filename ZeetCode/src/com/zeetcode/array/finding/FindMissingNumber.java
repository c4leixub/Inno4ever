package com.zeetcode.array.finding;

public class FindMissingNumber {
	
	public int missingNumberWithoutSort(int[] nums) {
		int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
        }
        
        int i = 0;
        while (i < nums.length) {
            sum = sum - nums[i];
            i++;
        }
        
        return sum;
	}
}
