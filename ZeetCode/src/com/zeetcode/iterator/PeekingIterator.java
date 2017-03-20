package com.zeetcode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {

    private Integer peek;
    private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator=iterator;
	    if (iterator.hasNext()) {
	        peek = iterator.next();
	    } else {
	        peek = null;
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		Integer ret = peek;
		if (iterator.hasNext()) {
	        peek = iterator.next();
	    } else {
	        peek = null;
	    }
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}

}
