package com.lkin.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dumb = new RandomListNode(0);
		RandomListNode p = head, q = dumb;
		
		Map<RandomListNode, RandomListNode> map;
		map = new HashMap<RandomListNode, RandomListNode>();

		while (p != null) {
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);

			p = p.next;
			q = q.next;
		}

		p = head;
		q = dumb.next;
		while (p != null) {
			q.random = map.get(p.random);

			p = p.next;
			q = q.next;
		}

		return dumb.next;
	}
}
