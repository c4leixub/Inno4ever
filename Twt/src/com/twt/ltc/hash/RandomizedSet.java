package com.twt.ltc.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Map<Integer, Integer> indexToVal;
	Map<Integer, Integer> valToIndex;
	Random random;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		indexToVal = new HashMap<>();
		valToIndex = new HashMap<>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (valToIndex.containsKey(val)) {
			return false;
		}

		int index = indexToVal.size();
		indexToVal.put(index, val);
		valToIndex.put(val, index);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		Integer index = valToIndex.get(val);
		if (index == null) {
			return false;
		}

		Integer lastIndex = indexToVal.size() - 1;
		Integer lastVal = indexToVal.get(lastIndex);

		indexToVal.put(index, lastVal);
		valToIndex.put(lastVal, index);

		indexToVal.remove(lastIndex);
		valToIndex.remove(val);

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return indexToVal.get(random.nextInt(indexToVal.size()));
	}
}
