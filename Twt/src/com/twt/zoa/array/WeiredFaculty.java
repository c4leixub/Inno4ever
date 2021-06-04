package com.twt.zoa.array;

import java.util.List;

public class WeiredFaculty {
	public int exam(List<Integer> v) {
		int friendResult = 0;
		for (Integer e : v) {
			friendResult += (e.intValue() == 1 ? 1 : -1);
		}
		
		int myResult = 0;
		for (int i = 0; i < v.size(); i++) {
			if (myResult > friendResult) {
				return i;
			}
			
			myResult += (v.get(i).intValue() == 1 ? 1 : -1);
			friendResult += (v.get(i).intValue() == 1 ? -1 : 1);
		}
		
		return v.size();	// should we compare result here and return -1?
	}
}
