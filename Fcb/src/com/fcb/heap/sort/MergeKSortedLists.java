package com.fcb.heap.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.fcb.node.ListNode;

public class MergeKSortedLists {
	
	class ListNodeAndIndex {
		public ListNode node;
		public int index; 
		public ListNodeAndIndex(ListNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {        
        PriorityQueue<ListNodeAndIndex> pq = new PriorityQueue<ListNodeAndIndex>(new Comparator<ListNodeAndIndex>() {
			@Override
			public int compare(ListNodeAndIndex o1, ListNodeAndIndex o2) {
				return o1.node.val - o2.node.val;
			}
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new ListNodeAndIndex(lists[i], i));
            }
        }
        
        int index;
        ListNode dump = new ListNode(0), p = dump;
        ListNodeAndIndex nodeAndIndex;
        while (!pq.isEmpty()) {
        	nodeAndIndex = pq.poll();
            
            p.next = new ListNode(nodeAndIndex.node.val);
            p = p.next;
            
            index = nodeAndIndex.index;
            lists[index] = lists[index].next;
            if (lists[index] != null) {
                pq.add(new ListNodeAndIndex(lists[index], index));
            }
        }
        
        return dump.next;
    }
}
