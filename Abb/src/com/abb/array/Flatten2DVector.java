package com.abb.array;

public class Flatten2DVector {
	private int[][] vector;
    private int row;
    private int col;
    
    public Flatten2DVector(int[][] v) {
        vector = v;
        row = 0;
        col = 0;
    }
    
    public int next() {
        if (!hasNext()) return -1;
        
        int val = vector[row][col];
        col++;
        
        return val;
    }
    
    public boolean hasNext() {
        if (row < vector.length) {
        	if (col < vector[row].length) {
        		return true;
        	} else {
        		row++;
        		col = 0;
        		while (row < vector.length && col >= vector[row].length) {
        			row++;
        		}
        		
        		return row < vector.length && col < vector[row].length;
        	}
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	int[][] v = new int[][] {{1,2},{3},{4}};
    	Flatten2DVector f = new Flatten2DVector(v);
    	while (f.hasNext()) {
    		System.out.println(f.next());
    	}
    }
}
