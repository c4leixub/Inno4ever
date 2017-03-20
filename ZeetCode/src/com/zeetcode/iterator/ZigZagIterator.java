package com.zeetcode.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ZigZagIterator {
	
	private Queue<List<Integer>> q = new LinkedList<List<Integer>>();
    private int index = 0;
    private int k = 0;
    
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        q.add(v1);
        q.add(v2);
    }

    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        
        List<Integer> top = q.poll();
        Integer re = top.get(index);
        k++;
        if (index + 1 < top.size()) {
            q.add(top);
        }
        
        return re.intValue();
    }

    public boolean hasNext() {
        while (!q.isEmpty() && index < q.peek().size()) {
            q.poll();
        }
        
        return !q.isEmpty();
    }
}
