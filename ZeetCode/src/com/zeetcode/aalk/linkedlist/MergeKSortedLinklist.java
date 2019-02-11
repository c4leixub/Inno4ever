package com.zeetcode.aalk.linkedlist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.zeetcode.node.ListNode;

public class MergeKSortedLinklist {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;

		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}

		});

		// the value is the index
		HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				minHeap.add(lists[i]);
				map.put(lists[i], i);
			}
		}

		ListNode dump = new ListNode(0);
		ListNode p = dump;

		ListNode next;
		while (!minHeap.isEmpty()) {
			next = minHeap.poll();
			int index = map.get(next);

			p.next = new ListNode(next.val);
			p = p.next;
			map.remove(next); // remove used key

			lists[index] = lists[index].next;
			if (lists[index] != null) {
				minHeap.add(lists[index]);
				map.put(lists[index], index);
			}
		}

		return dump.next;
	}
}
