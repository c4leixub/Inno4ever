package com.zeetcode.design;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
	
	private HashMap<Integer, Integer> data;
    private HashMap<Integer, Integer> valToIndex;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        data = new HashMap<Integer, Integer>();
        valToIndex = new HashMap<Integer, Integer>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        
        int index = data.size();
        data.put(index, val);
        valToIndex.put(val, index);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) { 
            return false;
        }
        
        int index = valToIndex.get(val);
        int lastVal = data.get(data.size()-1);
        
        data.put(index, lastVal);
        valToIndex.put(lastVal, index);
        
        data.remove(data.size()-1);
        valToIndex.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = random.nextInt(data.size());
        return data.get(r);
    }
}
