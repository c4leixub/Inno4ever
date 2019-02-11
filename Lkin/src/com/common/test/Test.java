package com.common.test;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		System.out.println("abc".substring(0, 0).length());
		System.out.println("abc".substring(0, 1));
		
		int[] nums = new int[] {5,4,0,3,1,6,2};
		Test t = new Test();
		System.out.println(t.arrayNesting(nums));
		

	}
	
	public int arrayNesting(int[] nums) {
        int max = 0;
        
        for (int s = 0; s < nums.length; s++) {
            int count = 0;
            boolean[] visited = new boolean[nums.length];
            int i = s;
            while (!visited[i]) {
                count++;
                visited[i] = true;
                i = nums[i];
            }
            Math.max(max, count);
        }
        
        return max;
    }

}
