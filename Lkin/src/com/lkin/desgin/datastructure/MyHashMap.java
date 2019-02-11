package com.lkin.desgin.datastructure;

public class MyHashMap {
	
	class ListNode {
        ListNode next;
        int key, val;
        
        ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    
    class Bucket {
        final ListNode head = new ListNode(-1, -1);
    }
    
    final int size = 10000;
    final Bucket[] buckets = new Bucket[size];

    public MyHashMap() {}
    
    private ListNode findPreNode(Bucket bucket, int key) {
        ListNode node = bucket.head;
        while (node.next != null && node.next.key != key) {
            node = node.next;
        }
        return node;
    }
    
    public void put(int key, int value) {
        int hash = key % size;;
        if (buckets[hash] == null) {
            buckets[hash] = new Bucket();
        }
        
        ListNode pre = findPreNode(buckets[hash], key);
        if (pre.next == null) {
            pre.next = new ListNode(key, value);
        } else {
            pre.next.val = value;
        }
    }
    
    public int get(int key) {
        int hash = key % size;;
        if (buckets[hash] == null) {
            return -1;
        }
        
        ListNode pre = findPreNode(buckets[hash], key);
        if (pre.next == null) {
            return -1;
        } else {
            return pre.next.val;
        }
    }
    
    public void remove(int key) {
        int hash = key % size;;
        if (buckets[hash] == null) {
            return;
        }
        
        ListNode pre = findPreNode(buckets[hash], key);
        if (pre.next == null) {
            return;
        } else {
            pre.next = pre.next.next;
        }
    }
}
