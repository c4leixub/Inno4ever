package com.twt.zpdm.hash;

import java.util.*;

public class MapDiff<K, T> {

	public Map<K, ValueDiff<T>> diff(Map<K, T> left, Map<K, T> right) {

		Map<K, ValueDiff<T>> result = new HashMap<>();

		T leftValue, rightValue;
		for (Map.Entry<K, T> entry : left.entrySet()) {
			leftValue = entry.getValue();
			rightValue = right.get(entry.getKey());

			if ((leftValue != null && rightValue != null && !leftValue.equals(rightValue))
					|| (leftValue != null && rightValue == null)
					|| (leftValue == null && rightValue != null)) {

				result.put(entry.getKey(), new ValueDiff<>(leftValue, rightValue));
			}
		}
		
		for (K key : right.keySet()) {
			if (result.containsKey(key)) {
				continue;
			}
			
			if (!left.containsKey(key)) {
				result.put(key, new ValueDiff<>(null, right.get(key)));
			}
		}

		return result;
	}
	
	public Map<K, T> onlyOnLeft(Map<K, T> left, Map<K, T> right) {
		Map<K, T> result = new HashMap<>();
		for (Map.Entry<K, T> entry : left.entrySet()) {
			if (!right.containsKey(entry.getKey())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	
	public Map<K, T> onlyOnRight(Map<K, T> left, Map<K, T> right) {
		Map<K, T> result = new HashMap<>();
		for (Map.Entry<K, T> entry : right.entrySet()) {
			if (!left.containsKey(entry.getKey())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, String> asia1 = new HashMap<String, String>();
	    asia1.put("Japan", "Tokyo");
	    asia1.put("South Korea", "Seoul");
	    asia1.put("India", "New Delhi");

	    Map<String, String> asia2 = new HashMap<String, String>();
	    asia2.put("Japan", "Tokyo");
	    asia2.put("China", "Beijing");
	    asia2.put("India", "Delhi");
	    
	    MapDiff<String, String> md = new MapDiff<>();
	    
	    Map<String, ValueDiff<String>> v = md.diff(asia1, asia2);
	    ValueDiff<String> vd;
	    for (String key : v.keySet()) {
	    	vd = v.get(key);
	    	System.out.println(key + " : " + vd.getLeft() + " " + vd.getRight());
	    }
	    
	    System.out.println();
	    System.out.println(md.onlyOnLeft(asia1, asia2));
	    
	    System.out.println();
	    System.out.println(md.onlyOnRight(asia1, asia2));
	}
}
