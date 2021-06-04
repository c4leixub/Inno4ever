package com.twt.zpdm.hash;

public class LinearProbHashTable<Key, Value> {

	private int currentSize;
	private int maxSize;
	private Value[] vals;
	private Key[] keys;
	
	private final static double DEFAULT_LOAD_FACTOR = 0.75;

	public LinearProbHashTable(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		keys = (Key[]) new Object[maxSize];
		vals = (Value[]) new Object[maxSize];
	}

	private int hash(Key key) {
		return key.hashCode() % maxSize;
	}

	public void put(Key key, Value val) {
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
			i = (i + 1) % maxSize;
		}

		// we found a empty space
		keys[i] = key;
		vals[i] = val;
		currentSize++;
	}

	public Value get(Key key) {
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
			i = (i + 1) % maxSize;
		}
		return null;
	}

	public void remove(Key key) {

		if (get(key) == null)
			return;

		// Find position key and delete
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i + 1) % maxSize;
		}
		keys[i] = null;
		vals[i] = null;
		
		// refresh all keys
		for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
			Key tmpKey = keys[i];
			Value tmpVal = vals[i];
			keys[i] = null;
			vals[i] = null;
			currentSize--;
			put(tmpKey, tmpVal);
			
		}
		currentSize--;
	}
	
	private void rehash() {
		double loadFactor = (1.0 * currentSize) / maxSize;
		if (loadFactor > DEFAULT_LOAD_FACTOR) {
			Key[] tmpKeys = keys;
			Value[] tmpVals = vals;
			
			currentSize = 0;
			maxSize *= 2;
			keys = (Key[]) new Object[maxSize];
			vals = (Value[]) new Object[maxSize];
			
			for (int i = 0; i < tmpKeys.length; i++) {
				this.put(keys[i], vals[i]);
			}
		}
	}

	public void clear() {
		currentSize = 0;
		keys = (Key[]) new Object[maxSize];
		vals = (Value[]) new Object[maxSize];
	}

	public int getSize() {
		return currentSize;
	}
}
