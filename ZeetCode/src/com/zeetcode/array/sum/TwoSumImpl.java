package com.zeetcode.array.sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumImpl implements TwoSum {

	Set<Integer> sum = new HashSet<Integer>();
	List<Integer> data = new ArrayList<Integer>();

	@Override
	public void Store(int input) {
		/*
		 * data.add(input);
		 */

		for (Integer e : data) {
			sum.add(e + input);
		}
		data.add(input);
	}

	@Override
	public boolean Test(int val) {
		/*
		 * Set<Integer> tmp = new HashSet<Integer>(); 
		 * for (Integer e : data) {
		 * 	if (tmp.contains(val-e)) { 
		 * 		return true; 
		 * 	} else { 
		 * 	tmp.add(e); 
		 * 	} 
		 * }
		 * return false;
		 */

		return sum.contains(val);
	}

	public static void main(String[] args) {
		TwoSumImpl s = new TwoSumImpl();
		s.Store(0);
		System.out.println(s.Test(0));
		s.Store(0);
		System.out.println(s.Test(0));
	}

}
