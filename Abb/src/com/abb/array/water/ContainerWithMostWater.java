package com.abb.array.water;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int max = 0, area = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
        	area = (right - left) * Math.min(height[left], height[right]);
        	max = Math.max(max, area);
        	
        	if (height[left] <= height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        }
        
        return max;
    }
}
