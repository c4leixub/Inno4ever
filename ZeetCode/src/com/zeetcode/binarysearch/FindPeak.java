package com.zeetcode.binarysearch;

public class FindPeak {
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
            	left = mid + 1;
            } else {	// nums[mid] > nums[mid + 1]
            	right = mid;
            }
        }
        return right;
    }
	
	public int isPeak(int[] nums) {
        int s = 0, e = nums.length-1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            
            if (isPeak(m, nums)) {
                return m;
            } else {
                if (nums[m] < nums[m+1]) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }
        }
        
        return -1;
    }
    
    public boolean isPeak(int i, int[] nums) {
        if (nums.length == 0) return false;
        
        if (nums.length == 1) {
            return (i == 0);
        }
        
        boolean left = i == 0 ? true : nums[i-1] < nums[i];
        boolean right = i == nums.length-1 ? true : nums[i] > nums[i+1];
        
        return left && right;
    }
}
