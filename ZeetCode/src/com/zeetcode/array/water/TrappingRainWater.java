package com.zeetcode.array.water;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length == 0) {
	        return 0;
	    }
		
	    int start = 0;
	    int end = height.length - 1;
	    int area = 0;
	    int smaller;
	    while (start < end) {
	        if (height[start] < height[end]) {
	            smaller = height[start]; 
	            while (start < end && height[start] <= smaller) {
	                area += smaller - height[start];
	                start++;
	            }
	        } else {
	            smaller = height[end];
	            while (start < end && height[end] <= smaller) {
	                area += smaller - height[end];
	                end--;
	            }
	        }
	    }
	    return area;
	}
}
