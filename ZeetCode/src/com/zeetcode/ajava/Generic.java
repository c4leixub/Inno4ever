package com.zeetcode.ajava;

import java.util.Iterator;

public class Generic {
	
	public class MyIterator<E> implements Iterator<E> {
		
		private E element;
		private Iterator<E> iterator;
		
		public MyIterator(Iterator<E> iterator) {
			element = iterator.next();
			this.iterator = iterator;
		}
		
		@Override
		public boolean hasNext() {
			// put ur implementation
			return false;
		}

		@Override
		public E next() {
			// put ur implementation
			return null;
		}	
	}
}
