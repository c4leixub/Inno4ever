package com.zeetcode.math;

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] result = new int[nums.length];
		
		int start = 0, end = nums.length - 1;
		int nextIndex = 0;
		
		if (a > 0 || (a == 0 && b >= 0))
			nextIndex = nums.length - 1;
		if (a < 0 || (a == 0 && b < 0))
			nextIndex = 0;
		
		double mid = -1 * ((b * 1.0) / (2.0 * a));
		
		while (start <= end) {
			if (a > 0 || (a == 0 && b >= 0)) {
				if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
					int x = nums[start++];
					result[nextIndex--] = a * x * x + b * x + c;
				} else {
					int x = nums[end--];
					result[nextIndex--] = a * x * x + b * x + c;
				}
			} else if (a < 0 || (a == 0 && b < 0)) {
				if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
					int x = nums[start++];
					result[nextIndex++] = a * x * x + b * x + c;
				} else {
					int x = nums[end--];
					result[nextIndex++] = a * x * x + b * x + c;
				}
			}
		}
		return result;
	}
	
	public int[] sortTransformedArray2(int[] nums, int a, int b, int c) {
		int j = 0;
        if (a != 0) {
        	// m is either MAX or MIN, and determine by isIncrease
            int m = -b / (2 * a);	
            while (nums[j] < m) {
                j++;
            }
        }
        
        int[] result = new int[nums.length];
        int k = isIncrease(a,b) ? 0 : nums.length-1;
        
        int i = j - 1, ti = 0, tj = 0;
        while (i >= 0 && j < nums.length) {
            ti = quadratic(a,b,c,nums[i]);
            tj = quadratic(a,b,c,nums[j]);
            
            if (isIncrease(a,b)) {    
                if (ti < tj) {
                    result[k] = ti;
                    i--;
                } else {
                    result[k] = tj;
                    j++;
                }
                k++;
            } else {
                if (ti > tj) {
                    result[k] = ti;
                    i--;
                } else {
                    result[k] = tj;
                    j++;
                }
                k--;
            }
            
        }
        
        while (j < nums.length) {
            result[k] = quadratic(a,b,c,nums[j]);
            j++;
            if (isIncrease(a,b)) {
                k++;
            } else {
                k--;
            }
        }
        
        while (i >= 0) {
            result[k] = quadratic(a,b,c,nums[i]);
            i--;
            if (isIncrease(a,b)) {
                k++;
            } else {
                k--;
            }
        }
        
        return result;
    }
    
    public int quadratic(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
    
    // Determine whether the function is a increase function
    public boolean isIncrease(int a, int b) {
        if (a == 0) {	// case for function is a line, then b >= 0 is an increase line
            return b >= 0;
        }
        
        return a > 0;	// m is MIN
    }
}
