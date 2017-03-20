package com.zeetcode.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedIterator {
	
	private class MyIterator implements Comparable<MyIterator> {
		public Integer value;
		public Iterator<Integer> iterator;
		
		public MyIterator(Integer value, Iterator<Integer> iterator) {
			this.value = value;
			this.iterator = iterator;
		}
		
		public boolean updateValue() {
			if (iterator.hasNext()) {
				value = iterator.next();
				return true;
			}
			return false;
		}
		
		public int compareTo(MyIterator o) {
			return this.value - o.value;
		}
	}
	
	public Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
		List<Integer> result = new ArrayList<Integer>();
		
		PriorityQueue<MyIterator> q = new PriorityQueue<MyIterator>();
		for (Iterator<Integer> iterator : iterators) {
			if (iterator.hasNext()) {
				q.add(new MyIterator(iterator.next(), iterator));
			}
		}
		
		MyIterator myIterator;
		while (!q.isEmpty()) {
			myIterator = q.poll();
			result.add(myIterator.value);
			
			// update the value & put back to PriorityQueue
			if (myIterator.updateValue()) {	
				q.add(myIterator);
			}
		}
		
		return result;
	}
}
