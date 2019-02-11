package com.lkin.nestedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NestedIterator {
	public class NestedIteratorStack implements Iterator<Integer> {

		private Stack<NestedInteger> stack;

		public NestedIteratorStack(List<NestedInteger> nestedList) {
			stack = new Stack<NestedInteger>();
			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				return null;
			}
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty() && !stack.peek().isInteger()) {
				List<NestedInteger> nestedList = stack.pop().getList();
				for (int i = nestedList.size() - 1; i >= 0; i--) {
					stack.push(nestedList.get(i));
				}
			}
			return !stack.isEmpty();
		}
	}

	public class NestedIteratorQueue implements Iterator<Integer> {

		private Queue<NestedInteger> queue;

		public NestedIteratorQueue(List<NestedInteger> nestedList) {
			queue = new LinkedList<NestedInteger>();
			flatten(nestedList);
		}

		private void flatten(List<NestedInteger> nestedList) {
			for (NestedInteger e : nestedList) {
				if (e.isInteger()) {
					queue.add(e);
				} else {
					flatten(e.getList());
				}
			}
		}

		@Override
		public Integer next() {
			return queue.poll().getInteger();
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
	}
}
