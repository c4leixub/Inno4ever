package com.zeetcode.aafb.array;

public class MoveZeros {
	public void moveZeroesToEnd(int[] nums) {
		int s = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int t = nums[s];
                nums[s] = nums[i];
                nums[i] = t;
                s++;
            }
            i++;
        }
	}
	
	public static void moveZeroesToFront(int[] nums) {
		int s = nums.length - 1, i = nums.length - 1;
        while (i > 0) {
            if (nums[i] != 0) {
                int t = nums[s];
                nums[s] = nums[i];
                nums[i] = t;
                s--;
            }
            i--;
        }
	}
	
}
