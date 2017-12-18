package com.zeetcode.aalk.stack;

import java.util.LinkedList;
import java.util.TreeMap;

public class MaxStack2 {
	class Node {
        public int val;
        public Node pre;
        public Node next;
        public Node(int x) {
            val = x;
        }
    }
    
    /** initialize your data structure here. */
    private TreeMap<Integer, LinkedList<Node>> map;
    private Node head;
    
    public MaxStack2() {
        map = new TreeMap<Integer, LinkedList<Node>>();
        head = null;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        node.next = head;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        
        if (!map.containsKey(x)) {
            map.put(x, new LinkedList<Node>());   
        }
        map.get(x).addFirst(node);
        
    }
    
    public int pop() {
        Node re = head;
        head = head.next;
        if (head != null) {
        	head.pre = null;
        }
        
        map.get(re.val).removeFirst();
        if (map.get(re.val).isEmpty()) {
            map.remove(re.val);
        }
        
        return re.val;
    }
    
    public int top() {
        return head.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = map.lastKey();
        if (max == head.val) {
        	return pop();
        }
        
        Node maxNode = map.get(max).removeFirst();
        if (map.get(max).isEmpty()) {
            map.remove(max);
        }
        
        Node pre = maxNode.pre;
        Node next = maxNode.next;
        
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }
        
        return max;
    }
    
    public static void main(String[] args) {
    	MaxStack2 s = new MaxStack2();
    	s.push(-95);
    	s.push(1);
    	System.out.println(s.popMax());
    	s.push(-44);
    	s.push(16);
    	System.out.println(s.top());
    	s.push(29);
    	s.push(65);
    	s.push(-18);
    	System.out.println(s.pop());
    	System.out.println(s.popMax());
    	System.out.println(s.pop());
    	s.push(78);
    }
}
