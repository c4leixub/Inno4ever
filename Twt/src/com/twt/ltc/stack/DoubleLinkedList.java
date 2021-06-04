package com.twt.ltc.stack;

import com.common.node.DoubleNode;

public class DoubleLinkedList {
	
	DoubleNode head, tail;

    public DoubleLinkedList() {
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
    }

    public DoubleNode add(int val) {
    	DoubleNode x = new DoubleNode();
    	x.val = val;
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = tail.prev.next = x;
        return x;
    }

    public int pop() {
        return unlink(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }
    
    public int last() {
        return tail.prev.val;
    }

    public DoubleNode unlink(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}
