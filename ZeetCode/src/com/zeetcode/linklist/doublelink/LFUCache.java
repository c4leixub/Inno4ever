package com.zeetcode.linklist.doublelink;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

	class DoubleNode {
        int key;
		int value;
	    int freq;
	    DoubleNode next;
	    DoubleNode pre;
	    DoubleNode(int k, int v) { 
	        key = k;
	        value = v;
	        freq = 1;
	    }
    }
    
    class FreqNode {
        int freq;
        DoubleNode head;
        DoubleNode end;
        
        FreqNode pre;
        FreqNode next;
        
        FreqNode(int f) {
            freq = f;
            head = null;
            end = null;
            
            pre = null;
            next = null;
        }
        
        public void setHead(DoubleNode newHead) {
            if (head != null) {
                head.pre = newHead;
                newHead.next = head;
                newHead.pre = null;
                head = newHead;
            } else {
                head = newHead;
                end = head;
            }
        }
    
        public void remove(DoubleNode node) {
            if (node == head && node == end) {
                head = null;
            } else if (node == head) {
                head = head.next;
                node.next = null;   // de-reference the old head
            } else if (node == end) {
                end = end.pre;
                end.next = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
        }
        
        public boolean isEmpty() {
            return head == null || end == null;
        }
    }

    private int capacity;
    private Map<Integer, DoubleNode> keyToNode;
    private Map<Integer, FreqNode> freqToKeys;
    private FreqNode head;
    private FreqNode end;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqToKeys = new HashMap<Integer, FreqNode>();
        keyToNode = new HashMap<Integer, DoubleNode>();
        head = null;
        end = null;
    }
    
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        
        DoubleNode keyNode = keyToNode.get(key);
        FreqNode curFreqNode = freqToKeys.get(keyNode.freq);
        
        curFreqNode.remove(keyNode);
        
        keyNode.freq++;;
        if (!freqToKeys.containsKey(keyNode.freq)) {
            FreqNode newFreqNode = new FreqNode(keyNode.freq);
            freqToKeys.put(keyNode.freq, newFreqNode);
            
            addNewFreq(newFreqNode, curFreqNode);
            if (curFreqNode.isEmpty()) {
                remove(curFreqNode);
            }
        }
        freqToKeys.get(keyNode.freq).setHead(keyNode);
        
        return keyNode.value;
    }
    
    public void set(int key, int value) {
        if (keyToNode.containsKey(key)) {
            DoubleNode keyNode = keyToNode.get(key);
            FreqNode curFreqNode = freqToKeys.get(keyNode.freq);
            
            curFreqNode.remove(keyNode);
            
            keyNode.freq++;;
            if (!freqToKeys.containsKey(keyNode.freq)) {
                FreqNode newFreqNode = new FreqNode(keyNode.freq);
                freqToKeys.put(keyNode.freq, newFreqNode);
                
                addNewFreq(newFreqNode, curFreqNode);
                if (curFreqNode.isEmpty()) {
                    remove(curFreqNode);
                }
            }
            freqToKeys.get(keyNode.freq).setHead(keyNode);
            
            keyNode.value = value;            
        } else {
            if (keyToNode.size() == capacity) {
                keyToNode.remove(end.end.key);
                end.remove(end.end);
                if (end.isEmpty()) {
                	remove(end);
                }
            }
            
            DoubleNode newKeyNode = new DoubleNode(key, value);
            keyToNode.put(key, newKeyNode);
            
            if (!freqToKeys.containsKey(newKeyNode.freq)) {
                FreqNode newFreqNode = new FreqNode(newKeyNode.freq);
                freqToKeys.put(newKeyNode.freq, newFreqNode);
                
                setEnd(newFreqNode);
            }
            freqToKeys.get(newKeyNode.freq).setHead(newKeyNode);
        }
    }
    
    private void setHead(FreqNode newHead) {
        if (head != null) {
            head.pre = newHead;
            newHead.next = head;
            newHead.pre = null;
            head = newHead;
        } else {
            head = newHead;
            end = head;
        }
    }
    
    private void setEnd(FreqNode newEnd) {
        if (end != null) {
            newEnd.pre = end;
            end.next = newEnd;
            end = newEnd;
        } else {
            head = newEnd;
            end = head;
        }
    }
    
    private void addNewFreq(FreqNode newNode, FreqNode lessOneNode) {
        if (lessOneNode == head) {
            setHead(newNode);
        } else {
            FreqNode pre = lessOneNode.pre;
            pre.next = newNode;
            newNode.pre = pre;
            
            newNode.next = lessOneNode;
            lessOneNode.pre = newNode;
        }
    }
    
    private void remove(FreqNode node) {
        if (node == head && node == end) {
            head = null;
        } else if (node == head) {
            head = head.next;
            node.next = null;   // de-reference the old head
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
    
    public static void main(String[] args) {
//    	["LFUCache","set","set","get","set","get","get","set","get","get","get"]
//    			[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
    	
    	LFUCache c = new LFUCache(2);
    	c.set(1, 1);
    	c.set(2,2);
    	System.out.println(c.get(1));
    	c.set(3,3);
    	System.out.println(c.get(2));
    	System.out.println(c.get(3));
    	c.set(4,4);
    	System.out.println(c.get(1));
    	System.out.println(c.get(3));
    	System.out.println(c.get(4));
    }
	
}
