package com.zeetcode.aafb.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
	public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<String>(nums.length,
        		new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						int i = 0, j = 0;
						char c1, c2;
						while (i < o1.length() && j < o2.length()) {
							c1 = o1.charAt(i); c2 = o2.charAt(j);
							if (c1 < c2) {
								return -1;
							} else if (c1 > c2) {
								return 1;
							}
							
							i++;
							j++;
						}
						return 0;
					}
        });
        
        return "";
    }
}
