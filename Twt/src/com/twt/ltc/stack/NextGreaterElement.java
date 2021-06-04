package com.twt.ltc.stack;

import java.util.HashMap;

public class NextGreaterElement {
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		// storing index of elements of nums2 in a hashmap
		for (int i = 0; i < nums2.length; i++) {
			hm.put(nums2[i], i);
		}
		// answer array
		int arr[] = new int[nums1.length];

		// Traversing elements of nums1
		for (int j = 0; j < nums1.length; j++) {
			boolean flag = false;
			// we start from index in nums2 for element of num1
			int start = hm.get(nums1[j]);
			for (int k = start; k < nums2.length; k++) {
				// first greater element
				if (nums2[k] > nums1[j]) {
					arr[j] = nums2[k];
					flag = true;
					break;
				}
			}
			// if no such element, we store -1
			if (!flag)
				arr[j] = -1;
		}
		
		return arr;
	}
}
