package com.zeetcode.datastructure;

public class HashTableImpl {
	
	class ListNode {
		public Object key;
		public Object value;
		public ListNode next;
	}
	
	private ListNode[] hashTable;
	private int capacity;
	private final double loadFactor = 0.75;
	
	public HashTableImpl(int capacity) {
		this.capacity = capacity;
		this.hashTable = new ListNode[this.capacity];
	}
	
	public Object get(Object key) {
		ListNode tmp = hashTable[key.hashCode() % this.capacity];
		while (tmp != null) {
			if (key.equals(tmp.key)) return tmp.value;
			tmp = tmp.next;
		}
		return null;
	}
	
	
	public void put(Object key, Object value) {
		int index = key.hashCode() % this.capacity;
		ListNode tmp = hashTable[index];
		if (tmp == null) {
			tmp = new ListNode();
			tmp.key = key;
			tmp.value = value;
			hashTable[index] = tmp;
			return;
		}
		
		while (tmp != null) {
			if (key.equals(tmp.key)) {
				tmp.value = value;
			}
			
			if (tmp.next == null) {
				ListNode p = new ListNode();
				p.key = key;
				p.value = value;
				tmp.next = p;
				return;
			}
			tmp = tmp.next;
		}		
	}
	
	private void reHashIt() {
		ListNode[] tmp = hashTable;
		
		hashTable = new ListNode[capacity*2];
		this.capacity *= 2;
		
		for (int i = 0; i < tmp.length; i++) {
			ListNode p = tmp[i];
			while (p != null) {
				put(p.key, p.value);
				p = p.next;
			}
		}
	}
	
	private boolean reHash() {
		int count = 0;
		for (int i = 0; i < capacity; i++) {
			if (hashTable[i] != null) count++;
		}
		return count >= capacity * loadFactor;
	}

	
}
