package com.twt.ltc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.common.node.DoubleNode;

public class MaxStackTreeMapImpl implements MaxStack {

	TreeMap<Integer, List<DoubleNode>> map;	// to get the max
	DoubleLinkedList dll;	// the stack

	/** initialize your data structure here. */
    public MaxStackTreeMapImpl() {
        map = new TreeMap<>();
        dll = new DoubleLinkedList();
    }

	public void push(int x) {
		DoubleNode node = dll.add(x);
		List<DoubleNode> list = map.get(x);	//O(log N), size of data struction
		if (list == null) {
			list = new ArrayList<>();
			map.put(x, list);
		}
		list.add(node);
	}

	public int pop() {
		int val = dll.pop();
		List<DoubleNode> list = map.get(val); //O(log N)
		list.remove(list.size() - 1);
		if (list.isEmpty()) {
			map.remove(val);
		}
		return val;
	}

	public int top() {
		return dll.peek();	//O(1)
	}

	public int peekMax() {
		return map.lastKey();	//O(log N)
	}

	public int popMax() {
		int max = this.peekMax();
		List<DoubleNode> list = map.get(max); //O(log N)
		DoubleNode node = list.remove(list.size() - 1);
		if (list.isEmpty()) {
			map.remove(max);
		}

		dll.unlink(node);
		return max;
	}
}
