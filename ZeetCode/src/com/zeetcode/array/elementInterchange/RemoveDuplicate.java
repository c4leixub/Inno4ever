package com.zeetcode.array.elementInterchange;

/**
 * For example,
Given input array nums = [1,1,2],

Your function should return length = 2, 
with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 *
 */
public class RemoveDuplicate {
	public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int length = nums.length;
        int k = 0;
        
        int i = 0;
        while (i < nums.length) {
            nums[k] = nums[i];
            i++;
            
            while (i < nums.length && nums[i] == nums[k] ) {
                i++;
                length--;
            }
            k++;
        }
        
        return length;
    }
}
