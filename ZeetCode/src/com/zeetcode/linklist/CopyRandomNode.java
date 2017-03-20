package com.zeetcode.linklist;

import java.util.HashMap;

public class CopyRandomNode {

	public class RandomListNode {
		int label;
		RandomListNode next, random;
		public RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dump = new RandomListNode(0);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		RandomListNode p = head;
		RandomListNode q = dump;

		while (p != null) {
			q.next = new RandomListNode(p.label);
			q = q.next;
			map.put(p, q);
			p = p.next;
		}

		p = head;
		q = dump.next;
		while (p != null) {
			q.random = map.get(p.random);

			p = p.next;
			q = q.next;
		}

		return dump.next;
	}
}
