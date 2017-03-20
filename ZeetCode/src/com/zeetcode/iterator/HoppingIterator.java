package com.zeetcode.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class HoppingIterator<T> implements Iterator<T> {

	private static final String ILLEGAL_MESSAGE = "numHops needs to be >= 0. You passed: %d";
	private final Iterator<T> iterator;
	private final int numHops;
	private T nextItem;
	private boolean first;

	public HoppingIterator(Iterator<T> iterator, int numHops) {
		if (numHops < 0) {
			throw new IllegalArgumentException(String.format(
					ILLEGAL_MESSAGE, numHops));
		}

		this.numHops = numHops;
		this.iterator = iterator;
		nextItem = null;
		first = true;
	}

	@Override
	public boolean hasNext() {
		if (nextItem != null) {	// we had found the next element
			return true;
		}
		
		// find the next element
		if (first) {
			nextItem = iterator.next();
			first = false;
		} else {
			for (int i = 0; i < numHops && iterator.hasNext();i++) {
				iterator.next();
			}
			
			nextItem = iterator.hasNext() ? iterator.next() : null;
		}
		
		return nextItem != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		T ret = nextItem;
		nextItem = null;	// to make hasNext to get then next element
		return ret;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		HoppingIterator<Integer> hi = new HoppingIterator<Integer>(
				list.iterator(), 2);
		System.out.println(hi.next());
		System.out.println(hi.next());
		System.out.println(hi.hasNext());
	}
}