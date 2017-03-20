package com.zeetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Flatten2DVector {
	
	int row = 0, col = 0;
	List<List<Integer>> vec2d;
	
	public Flatten2DVector(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
	}
	
	public Integer next() {
		if (!hasNext()) throw new NoSuchElementException();
		
		Integer e = vec2d.get(row).get(col);
		col++;
		return e;
	}
	
	public boolean hasNext() {
		if (row >= vec2d.size()) return false;
		
		if (col >= vec2d.get(row).size()) {
			row++;
			col = 0;
			while (row < vec2d.size() && vec2d.get(row).isEmpty()) {
				row++;
			}
			
			if (row >= vec2d.size()) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		vec2d.add(Arrays.asList(1,2,3));
		vec2d.add(new ArrayList<Integer>());
		vec2d.add(Arrays.asList(5,6));
		
		Flatten2DVector f = new Flatten2DVector(vec2d);
		while (f.hasNext()) {
			System.out.print(f.next() + " ");
		}
		System.out.println();
	}
}
