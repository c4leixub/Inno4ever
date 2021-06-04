package com.twt.ltc.unionfind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongConsecutiveArray {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);	// O(nlogn)
        
        int max = 1, i = 0, len = 1;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i+1]) {
                if (nums[i] + 1 == nums[i+1]) {
                    len++;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            i++;
        }
        max = Math.max(max, len);
        
        return max;
    }
	
	public int longestConsecutiveHash(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int max = 1, len, curNum;
        for (int num : nums) {
        	if (!set.contains(num-1)) {
                len = 1;
                curNum = num + 1;
                while (set.contains(curNum)) {
                    len++;
                    curNum++;
                }
                max = Math.max(max, len);
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		LongConsecutiveArray a = new LongConsecutiveArray();
		a.longestConsecutiveHash(new int[] {100,4,200,1,3,2});
	}
}
