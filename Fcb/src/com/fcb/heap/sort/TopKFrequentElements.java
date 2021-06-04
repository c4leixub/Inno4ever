package com.fcb.heap.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	
	public int[] topKFrequent(int[] nums, int k) {
		
		int[] res = new int[k];
		
		Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
		for (int num : nums) {
			numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
		}
		
		Map<Integer, List<Integer>> countToNums = new HashMap<Integer, List<Integer>>();
		List<Integer> list;
		Integer count, max = Integer.MIN_VALUE;
		for (Integer num : numCounts.keySet()) {
			count = numCounts.get(num);
			list = countToNums.get(count);
			if (list == null) {
				list = new ArrayList<Integer>();
				countToNums.put(count, list);
			}
			list.add(num);
			max = Math.max(max, count);
		}

		int i = 0;
		for (int ct = max; ct >= 0 && i < k; ct--) {
			for (Integer num : countToNums.getOrDefault(ct, Collections.emptyList())) {
				res[i] = num;
				i++;
				
				if (i == k) {
					break;
				}
			}
		}
		
		return res;
	}
}
