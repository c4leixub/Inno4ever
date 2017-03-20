package com.zeetcode.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ZigZigIteratorMultiple implements Iterator<Integer> {

	private LinkedList<Iterator<Integer>> q = new LinkedList<Iterator<Integer>>();

	public ZigZigIteratorMultiple(List<Integer>[] valueLists) {
		for (List<Integer> valueList : valueLists) {
			q.add(valueList.iterator());
		}
	}

	public Integer next() {
		if (!hasNext())
			throw new NoSuchElementException();

		Iterator<Integer> top = q.poll();
		Integer re = top.next();
		q.add(top);

		return re.intValue();
	}

	public boolean hasNext() {
		while (!q.isEmpty() && !q.peek().hasNext()) {
			q.poll();
		}

		return !q.isEmpty();
	}
}
