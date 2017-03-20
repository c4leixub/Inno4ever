package com.zeetcode.ajava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SortCollections {
	
	private static class IntObject implements Comparable<IntObject> {
		private Integer intValue = 0;
		
		public IntObject(Integer intValue) {
			this.intValue = intValue;
		}
		
		@Override
		public int compareTo(IntObject o) {
			// put ur implementation
			return this.intValue.compareTo(o.intValue);
		}
	}
	
	public static void main(String[] args) {
		
		// ----------------	PriorityQueue usage ----------------
		int size = 10;	
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(size, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// put ur implementation
				return o1.compareTo(o2);
			}
		});
		pq.add(1);
		pq.poll();
		pq.peek();
		
		
		// ----------------	Sorting Array and List ----------------
		Integer[] array = new Integer[] {3, 5, 1, 3, 6};
		List<IntObject> list = new ArrayList<IntObject>();
		
		Arrays.sort(array);		// Arrays.sort(array, new Comparator<Integer>() { .... });
		Collections.sort(list);		//	Collections.sort(list, new Comparator<IntObject>() { .... });
		
		list.addAll(Collections.emptyList());
		
		
		// ----------------	Hash ----------------
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(2);
		
		List<Integer> c = new ArrayList<Integer>();
		c.add(2);
		c.add(1);
		
		// true	false
		System.out.println(a.equals(b) + " " + a.equals(c));	
		
		// true false
		System.out.println((a.hashCode() == b.hashCode()) + " " + (a.hashCode() == c.hashCode()));
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(null, null);
		
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		// ht.put(null, null); throw NullpointerException
		// If Two list has same number of element and their order is the same, the hash is the same
		
		
		// ----------------	Stack and Queue ----------------
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.peek();
		stack.pop();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(3);
		queue.peek();
		queue.poll();
	}
}
