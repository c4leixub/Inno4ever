package com.lkin.array.other;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the
 * number of triplets chosen from the array that can make triangles
 * i.e. if a <= b <= c, then nums[a] + nums[b] > nums[c]
 */
public class ValidTriangleNumber {
	public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);	// sorting time O(nlogn), space O(logn)
            
        int n = nums.length;
        int count = 0;
        for (int c = n - 1; c >= 2; c--) {      // O(n^2)  
            int a = 0, b = c - 1;
            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    count += (b-a);		//all the number at index a, a+1, .... b-1 can pair with b satisfy the condition
                    b--;
                } else {
                    a++;
                }
            }
        }
        
        return count;
        
    }
}
