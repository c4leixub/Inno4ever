package com.zeetcode.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ConstantOperationList<T> {
	
	public Random r = new Random();
	public ArrayList<T> array = new ArrayList<T>();
	public HashMap<T, Integer> map = new HashMap<T, Integer>();
	public int size = 0;
	
	// Inserts an item x to the data structure if not already present.
	public void add(T t) {
		if (map.containsKey(t))	return;
		
		array.add(size, t);
		map.put(t, size);
		size++;
	}
	
	// Removes an item x from the data structure if present.
	public void remove(T t) {
		Integer index = map.get(t);
		if (index != null) {
			T d = array.get(size - 1);
			
			array.set(index, d);
			array.remove(size-1);
			
			map.put(d, index);
			map.remove(t);
			
			size--;
			
		}
	}
	
	public T getRandomElement() {
		int index = r.nextInt(size);
		return array.get(index);
	}
	
	public static void main(String[] args) {
		ConstantOperationList<String> k = new ConstantOperationList<String>();
		k.add("a");
		k.add("v");
		k.add("h");
		k.add("a");
		k.add("b");
		k.add("w");
		
		
		System.out.println(k.map);
		
		k.remove("v");
		
		System.out.println(k.map);
		System.out.println(k.array);
		
		System.out.println(k.getRandomElement());
		
	}
}
