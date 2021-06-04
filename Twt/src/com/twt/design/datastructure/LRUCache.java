package com.twt.design.datastructure;

import java.util.*;

import com.common.node.DoubleNode;

public class LRUCache {

	private Map<Integer, DoubleNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DoubleNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;

		head = new DoubleNode();	// head.prev = null;
		
		tail = new DoubleNode();	// tail.next = null;
		
		head.next = tail;
		tail.prev = head;
	}

	// Always add the new node right after head.
	private void addNode(DoubleNode node) {
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	// Remove an existing node from the linked list.
	private void removeNode(DoubleNode node) {
		DoubleNode prev = node.prev;
		DoubleNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	// Move certain node in between to the head.
	private void moveToHead(DoubleNode node) {
		removeNode(node);
		addNode(node);
	}

	// Pop the current tail.
	private DoubleNode popTail() {
		DoubleNode res = tail.prev;
		removeNode(res);
		return res;
	}

	public int get(int key) {
		DoubleNode node = cache.get(key);
		if (node == null)
			return -1;

		// move the accessed node to the head;
		moveToHead(node);

		return node.val;
	}

	public void put(int key, int value) {
		DoubleNode node = cache.get(key);

		if (node == null) {
			DoubleNode newNode = new DoubleNode();
            newNode.key = key;
			newNode.val = value;

			cache.put(key, newNode);
			addNode(newNode);

			size++;

			if (size > capacity) {
				// pop the tail
				DoubleNode tail = popTail();
				cache.remove(tail.key);
				size--;
			}
		} else {
			// update the value.
			node.val = value;
			moveToHead(node);
		}
	}
}
