package com.zeetcode.linklist.doublelink;

import java.util.HashMap;

public class LRUCache {

	class Node{
	    int key;
	    int value;
	    Node pre;
	    Node next;
	 
	    public Node(int key, int value){
	        this.key = key;
	        this.value = value;
	    }
	}
	
	private int capacity;
	private HashMap<Integer, Node> cache;
	Node head = null, end = null;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<Integer, Node>();
	}
	
	public int get(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}
	
	public void set(int key, int value) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			remove(node);
			setHead(node);
			node.value = value;
		} else {
			if (cache.size() == capacity) {
				cache.remove(end.key);
				remove(end);
			}
			setHead(new Node(key, value));
			cache.put(key, head);
		}
	}
	
	private void remove(Node node) {
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			head = node.next;
		}
		
		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			end = node.pre;
		}
	}
	
	private void setHead(Node node) {
		node.pre = null;
		node.next = head;
		
		if (head != null)
			head.pre = node;
		
		head = node;
		
		if (end == null) {
			end = head;
		}
	}
}
