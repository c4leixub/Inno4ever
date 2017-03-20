package com.zeetcode.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RepeatIntIterator implements Iterator<Integer>{
 
	private Iterator<Integer> iterator;
	private Integer n = 0;
	private Integer value;
	
	public RepeatIntIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasNext() {
		if (n > 0) {
			return true;
		}
		
		if (iterator.hasNext()) {
			n = iterator.next();
			if (iterator.hasNext()) {
				value = iterator.next();
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		n--;
		return value;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,5,8);
		RepeatIntIterator r = new RepeatIntIterator(list.iterator());
		while (r.hasNext()) {
			System.out.print(r.next() + " ");
		}
	}

}
