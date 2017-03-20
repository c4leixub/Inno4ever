package com.zeetcode.integer.nested;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

	private Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<NestedInteger>();

		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			NestedInteger e = stack.pop();
			return e.getInteger();
		}
		
		throw new NoSuchElementException();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger top = stack.peek();
			if (top.isInteger()) {
				return true;
			} else {
				stack.pop();
				for (int i = top.getList().size() - 1; i >= 0; i--) {
					stack.push(top.getList().get(i));
				}
			}
		}

		return false;
	}

}
