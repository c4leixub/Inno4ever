package com.zeetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {

	private HashMap<Integer, Integer> data;
	private HashMap<Integer, Set<Integer>> valToIndexes;
	private Random random;

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		data = new HashMap<Integer, Integer>();
		valToIndexes = new HashMap<Integer, Set<Integer>>();
		random = new Random();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		int sz = data.size();
		data.put(sz, val);

		if (valToIndexes.containsKey(val)) {
			valToIndexes.get(val).add(sz);
			return false;
		}

		valToIndexes.put(val, new HashSet<Integer>());
		valToIndexes.get(val).add(sz);
		return true;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (!valToIndexes.containsKey(val)) {
			return false;
		}

		Set<Integer> s = valToIndexes.get(val);
		int index = s.iterator().next();
		s.remove(index);
		if (s.isEmpty()) {
			valToIndexes.remove(val);
		}

		if (index == data.size() - 1) {
			data.remove(index);
			return true;
		}

		int lastVal = data.get(data.size() - 1);

		Set<Integer> t = valToIndexes.get(lastVal);
		t.remove(data.size() - 1);
		t.add(index);

		data.remove(data.size() - 1);
		data.put(index, lastVal);

		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int r = random.nextInt(data.size());
		return data.get(r);
	}

	public static void main(String[] args) {
		RandomizedCollection r = new RandomizedCollection();
		r.insert(0);
		r.insert(1);
		r.insert(2);
		r.insert(3);
		r.insert(3);
		r.remove(2);
		r.remove(3);

		System.out.println(r.data);
		System.out.println(r.valToIndexes);
	}
}
