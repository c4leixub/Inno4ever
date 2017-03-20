package com.zeetcode.bucketsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
public class TopKMostFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int a : nums) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		} // O(n)
		
		
		HashMap<Integer, ArrayList<Integer>> frequencyToInts = new HashMap<Integer, ArrayList<Integer>>();
		int max = 0;	// the most frequent time
		for (Integer key : map.keySet()) {
			max = Math.max(max, map.get(key));
			
			if (frequencyToInts.get(map.get(key)) != null) {
				frequencyToInts.get(map.get(key)).add(key);
			} else {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(key);
				frequencyToInts.put(map.get(key), newList);
			}
		}
		
		for (int i = max; i >= 1 && result.size() < k; i--) {
			if (frequencyToInts.get(i) == null) continue;
			for (int j = 0; j < frequencyToInts.get(i).size() && result.size() < k; j++) {
				result.add(frequencyToInts.get(i).get(j));
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		TopKMostFrequentElement t = new TopKMostFrequentElement();
		
		int[] nums = new int[] {1,1,1,2,2,3,3,3,3,4,4,5,5,5,5,6};
		System.out.println(t.topKFrequent(nums, 3));
	}
	
	
}
