package com.zeetcode.bucketsort;

/**
 * array contains three colors: 0, 1, 2
 * sort to become 0......,1.....,....
 */
public class SortColor {
	public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[0]++;
            } else if (nums[i] == 1) {
                count[1]++;
            } else if (nums[i] == 2) {
                count[2]++;
            }
        }
        
        int i = 0, k = 0;
        while (i < nums.length) {
        		if (count[k] == 0) {
        			k++;
        		}
        		nums[i] = k;
    			i++;
    			count[k]--;
        }
    }
	
	// sort to become 0, 1, 2, 0, 1, 2.........
	public void sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[0]++;
            } else if (nums[i] == 1) {
                count[1]++;
            } else if (nums[i] == 2) {
                count[2]++;
            }
        }
        
        int i = 0, k = 0;
        while (i < nums.length) {
        		k = k % 3;
        		while (count[k] == 0) {
        			k = (k+1) % 3;
        		}
        		
        		nums[i] = k;
        		count[k]--;
    			
        		i++;
    			k++;
        }
    }
	
}
