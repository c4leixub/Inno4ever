package com.zeetcode.contantruntime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OoneDataStructure {
	private Map<Integer, Set<String>> valToKeys;
    private Map<String, Integer> keyToVal;
    private int min;
    private int max;
    
    /** Initialize your data structure here. */
    public OoneDataStructure() {
        valToKeys = new HashMap<Integer, Set<String>>();
        keyToVal = new HashMap<String, Integer>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyToVal.containsKey(key)) {
            int oldVal = keyToVal.get(key);
            int newVal = keyToVal.get(key) + 1;
            
            valToKeys.get(oldVal).remove(key);
            if (valToKeys.get(min).isEmpty()) {
                min = newVal;
            }
            
            if (!valToKeys.containsKey(newVal)) {
                valToKeys.put(newVal, new HashSet<String>());
            }
            valToKeys.get(newVal).add(key);
            max = Math.max(max, newVal);
            
            keyToVal.put(key, newVal);
        } else {
            if (!valToKeys.containsKey(1)) {
                valToKeys.put(1, new HashSet<String>());
            }
            valToKeys.get(1).add(key);
            
            min = 1;
            max = Math.max(max, 1);
            
            keyToVal.put(key, 1);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyToVal.containsKey(key)) {
            return;
        }
        
        int oldVal = keyToVal.get(key);
        int newVal = keyToVal.get(key) - 1;
        
        valToKeys.get(oldVal).remove(key);
        
        if (newVal == 0) {
            keyToVal.remove(key);
            if (valToKeys.get(max).isEmpty()) {
                max = Integer.MIN_VALUE;
            }
            
            if (valToKeys.get(min).isEmpty()) {
                min = Integer.MAX_VALUE;
            }
            
        } else {
            if (valToKeys.get(max).isEmpty()) {
                max = newVal;
            }
            
            keyToVal.put(key, newVal);
            valToKeys.get(newVal).add(key);
            
            min = Math.min(min, newVal);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (valToKeys.get(max).isEmpty()) {
            return "";
        }
        
        return valToKeys.get(max).iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (valToKeys.get(min).isEmpty()) {
            return "";
        }
        
        return valToKeys.get(min).iterator().next();
    }
    
    public static void main(String[] args) {
    	OoneDataStructure o = new OoneDataStructure();
    	o.inc("hello");
    	o.inc("world");
    	o.inc("hello");
    	o.dec("world");
    	o.inc("hello");
    	//o.inc("leet");
    	//System.out.println(o.getMaxKey());
    	
    }
}
