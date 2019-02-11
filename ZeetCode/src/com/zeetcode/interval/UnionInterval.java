package com.zeetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class UnionInterval {
	
	public List<Interval> union(List<Interval> list1, List<Interval> list2) {
		List<Interval> result = new ArrayList<Interval>();
		
		int i = 0, j = 0;
		Interval pre = null, cur;
		if (list1.get(i).start <= list2.get(j).start) {
			pre = list1.get(i);
			i++;
		} else {
			pre = list2.get(j);
			j++;
		}
		
		
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i).start <= list2.get(j).start) {
				cur = list1.get(i);
				i++;
			} else {
				cur = list2.get(j);
				j++;
			}
			
			if (pre.end < cur.start) {
				result.add(pre);
				pre = cur;
			} else {
				pre = new Interval(pre.start, Math.max(pre.end, cur.end));
			}
		}
		
		while (i < list1.size()) {
			cur = list1.get(i);
			i++;
			if (pre.end < cur.start) {
				result.add(pre);
				pre = cur;
			} else {
				pre = new Interval(pre.start, Math.max(pre.end, cur.end));
			}
		}
		
		while (j < list2.size()) {
			cur = list2.get(j);
			j++;
			if (pre.end < cur.start) {
				result.add(pre);
				pre = cur;
			} else {
				pre = new Interval(pre.start, Math.max(pre.end, cur.end));
			}
		}
		
		result.add(pre);
		
		return result;
	}
 
}
