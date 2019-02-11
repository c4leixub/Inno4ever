package com.zeetcode.aafb.binarysearch;

public class FindFirstAndLast {
	
	public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};  
        int index = searchRightIndex(nums, 0, nums.length - 1, target);  
        if (index < 0 || nums[index] != target)  
            return result;  
        result[0] = searchLeftIndex(nums, 0, index, target);  
        result[1] = index;  
        return result;  
    }
    
    public int searchRightIndex(int[] nums, int left, int right, int target) {  
        while (left <= right) {  
            int mid = (left + right) / 2;  
            if (nums[mid] > target) right = mid - 1;  
            else left = mid + 1;  
        }  
        return right;  
    }
    
    public int searchLeftIndex(int[] nums, int left, int right, int target) {  
        while (left <= right) {  
            int mid = (left + right) / 2;  
            if (nums[mid] < target) left = mid + 1;  
            else right = mid - 1;  
        }  
        return left;  
    }
}
