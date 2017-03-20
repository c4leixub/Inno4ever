package com.zeetcode.array.sum;

import java.util.HashMap;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 * @author dij052
 *
 */
public class TwoSumOO {
	
	HashMap<Integer, Integer> numToCountMap = new HashMap<Integer, Integer>();
	
	public void add(int number) {
		if (numToCountMap.containsKey(number)) {
			numToCountMap.put(number, numToCountMap.get(number) + 1);
		} else {
			numToCountMap.put(number, 1);
		}
	}
	
	public boolean find(int value) {
		for (Integer key : numToCountMap.keySet()) {
			if (numToCountMap.containsKey(value-key) 
					&& (value != 2 * key || numToCountMap.get(key) >= 2)) {
				return true;
			}
		}
		
		return false;
	}
}
