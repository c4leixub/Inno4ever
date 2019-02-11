package com.lkin.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.common.structs.ListNode;

public class MergerKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy, node = null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
			new Comparator<ListNode>() {
				public int compare(ListNode l1, ListNode l2) {
	                return l1.val - l2.val;
	            }
        	});

		Map<ListNode, Integer> nodeToIndex = new HashMap<ListNode, Integer>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null)
				continue;

			nodeToIndex.put(lists[i], i);
			queue.add(lists[i]);
		}

		while (!queue.isEmpty()) {
			node = queue.poll();

			p.next = new ListNode(node.val);
			p = p.next;

			int index = nodeToIndex.get(node);
			nodeToIndex.remove(node);

			lists[index] = lists[index].next;
			if (lists[index] != null) {
				queue.add(lists[index]);
				nodeToIndex.put(lists[index], index);
			}
		}

		return dummy.next;
	}
}
