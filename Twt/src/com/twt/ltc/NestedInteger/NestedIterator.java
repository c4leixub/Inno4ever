package com.twt.ltc.NestedInteger;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
	
	Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		for (int j = nestedList.size() - 1; j >= 0; j--) {
			stack.add(nestedList.get(j));
		}
	}

	@Override
	public Integer next() {
		if (this.hasNext()) {
			return stack.pop().getInteger();
		}

		throw new NoSuchElementException();
	}

	@Override
	public boolean hasNext() {

		NestedInteger top;
		List<NestedInteger> nestedList;
		while (!stack.isEmpty()) {
			if (stack.peek().isInteger()) {
				return true;
			}

			top = stack.pop();
			nestedList = top.getList();
			for (int j = nestedList.size() - 1; j >= 0; j--) {
				stack.add(nestedList.get(j));
			}
		}

		return false;
	}
}
