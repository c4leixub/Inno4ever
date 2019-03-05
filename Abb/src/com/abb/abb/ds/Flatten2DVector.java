package com.abb.abb.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Flatten2DVector {
	
	private List<List<Integer>> vector;
    
	private Iterator<List<Integer>> rowIterator;
	private Iterator<Integer> colIterator;

    public Flatten2DVector(int[][] v) {
    	vector = new ArrayList<>();
    	List<Integer> list;
    	for (int i = 0; i < v.length; i++) {
    		list = new ArrayList<>();
    		for (int j = 0; j < v[i].length; j++) {
    			list.add(v[i][j]);
    		}
    		vector.add(list);
    	}
    	
    	rowIterator = vector.iterator();
    	colIterator = Collections.emptyIterator();
    }
    
    public void reInit() {
    	rowIterator = vector.iterator();
    	colIterator = Collections.emptyIterator();
    }
    
    public Integer next() {
    	if (!hasNext()) throw new NoSuchElementException();
    	
        return colIterator.next();
    }
    
    public boolean hasNext() {
        while(!colIterator.hasNext() && rowIterator.hasNext()) {
        	colIterator = rowIterator.next().iterator();
        }
        
        return colIterator.hasNext();
    }
    
    public void remove() {
//    	while (colIterator == null && rowIterator.hasNext())
//    		colIterator = rowIterator.next().iterator();
    	
    	colIterator.remove();	
    }
    
    public static void main(String[] args) {
    	int[][] v = new int[][] {{1,2},{3},{4}};
    	Flatten2DVector f = new Flatten2DVector(v);
    	
    	f.next();
    	f.next();
    	f.next();
    	f.next();
    	f.remove();
    	
    	f.reInit();
    	f.next();
    	f.next();
    	f.next();
    	f.next();
    	
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);list.add(2);list.add(3);
    	
    	Iterator<Integer> itr = list.iterator();
    	try {	itr.remove(); } catch (Exception e) {System.out.println("never call next method"); }
    	
    	itr.next();
    	
    	itr.next();
    	itr.remove();
    	
    	itr.next();
    	itr.remove();
    }
}
