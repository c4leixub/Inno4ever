package com.twt.zpdm.randomstructure;

import java.util.*;

import com.common.node.DoubleNode;
import com.twt.ltc.stack.DoubleLinkedList;

public class RandomizedSetWithGetLast {
	
	List<Integer> list;
	Map<Integer, Integer> valToIndex;
	
	Random random;
	
	DoubleLinkedList dll;
	Map<Integer, DoubleNode> valToNode;

	public RandomizedSetWithGetLast() {
		list = new ArrayList<>();
		valToIndex = new HashMap<>();
		
		random = new Random();
		
		dll = new DoubleLinkedList();
        valToNode = new HashMap<>();
	}

	public boolean insert(int val) {
		if (valToIndex.containsKey(val)) {
			return false;
		}

		valToIndex.put(val, list.size());
		list.add(val);
		
		DoubleNode node = dll.add(val);
        valToNode.put(val, node);
        
		return true;
	}

	public boolean remove(int val) {
		Integer index = valToIndex.get(val);
		if (index == null) {
			return false;
		}

		int lastIndex = list.size() - 1;
		Integer lastVal = list.get(lastIndex);
		
		list.set(index, lastVal);
		valToIndex.put(lastVal, index);
		
		list.remove(lastIndex);
		valToIndex.remove(val);
		
		DoubleNode node = valToNode.remove(val);
		dll.unlink(node);

		return true;
	}

	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
	
	public int getLast() {
		return dll.last();
	}
}
