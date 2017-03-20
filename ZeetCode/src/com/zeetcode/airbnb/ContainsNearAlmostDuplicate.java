package com.zeetcode.airbnb;

import java.util.TreeSet;

public class ContainsNearAlmostDuplicate {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || k <= 0) {
            return false;
        }
        
        TreeSet<Long> appearedSet = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
          Long potentialNum = appearedSet.ceiling((long)nums[i] - t);
          if (potentialNum != null && potentialNum <= (long) nums[i] + t) {
            return true;
          }
          if (i >= k) {
            appearedSet.remove((long)nums[i - k]);
          }
          appearedSet.add((long)nums[i]);
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		
		int[] nums = new int[] {1,3,4,5};
		int k = 3, t = 2;
		
		ContainsNearAlmostDuplicate c = new ContainsNearAlmostDuplicate();
		System.out.println(c.containsNearbyAlmostDuplicate(nums, k, t));
		
	}
}
