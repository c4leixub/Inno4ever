package com.twt.design.datastructure;

import java.util.*;

import javafx.util.Pair;

public class MyHashMap {
	private int key_space;
	private List<Bucket> hash_table;

	/** Initialize your data structure here. */
	public MyHashMap() {
		key_space = 2069;
		hash_table = new ArrayList<Bucket>(key_space);
		for (int i = 0; i < key_space; ++i) {
			hash_table.add(new Bucket());
		}
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash_key = key % this.key_space;
		hash_table.get(hash_key).addOrUpdate(hash_key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash_key = key % this.key_space;
		return hash_table.get(hash_key).get(key);
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash_key = key % this.key_space;
		hash_table.get(hash_key).delete(key);
	}

	class Bucket {
		private List<Pair<Integer, Integer>> bucket;

		public Bucket() {
			bucket = new LinkedList<>();
		}

		public void addOrUpdate(Integer key, Integer value) {
			Pair<Integer, Integer> p = this.getPair(key);
			if (p != null) {
				p.second = value;
			} else {
				bucket.add(new Pair<>(key, value));
			}
		}

		public Integer get(Integer key) {
			Pair<Integer, Integer> p = this.getPair(key);
			return p != null ? p.second : -1;
		}

		public void delete(Integer key) {
			Iterator<Pair<Integer, Integer>> itr = bucket.iterator();
			Pair<Integer, Integer> p;
			while (itr.hasNext()) {
				p = itr.next();
				if (p.first.equals(key)) {
					itr.remove();
					break;
				}
			}
		}

		private Pair<Integer, Integer> getPair(Integer key) {
			for (Pair<Integer, Integer> p : bucket) {
				if (p.first.equals(key)) {
					return p;
				}
			}
			return null;
		}
	}

	class Pair<U, V> {
		public U first;
		public V second;

		public Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}
}
