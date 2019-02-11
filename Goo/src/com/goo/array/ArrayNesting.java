package com.goo.array;

public class ArrayNesting {
	
	// Time: O(n), Space: O(n)
	public int arrayNesting(int[] nums) {
        int max = 0, start = -1, count= 0;
        boolean[] visited = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                start = nums[nums[i]];
                count = 1;
                while (start != nums[i]) {
                    visited[start] = true;
                    start = nums[start];
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
	
	// Time: O(n), Space: O(1)
	public int arrayNestingBetter(int[] nums) {
        int max = 0, start = -1, count= 0, temp = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                start = nums[i];
                count = 0;
                
                while (nums[start] != -1) {
                    temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = -1;
                }
                
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}
