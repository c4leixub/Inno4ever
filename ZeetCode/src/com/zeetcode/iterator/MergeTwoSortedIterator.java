package com.zeetcode.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeTwoSortedIterator {
	public Iterable<Integer> mergeTwoSortedIterators(Iterator<Integer> i1, Iterator<Integer> i2) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (!i1.hasNext()) {
			while(i2.hasNext()) {
				result.add(i2.next());
			}
			return result;
		}
		
		if (!i2.hasNext()) {
			while(i1.hasNext()) {
				result.add(i1.next());
			}
			return result;
		}
		
		Integer e1 = i1.next();
		Integer e2 = i2.next();
		
		while (i1.hasNext() && i2.hasNext()) {
			if (e1 <= e2) {
				result.add(e1);
				e1 = i1.next();
			} else {
				result.add(e2);
				e2 = i2.next();
			}
		}
		
		if (i1.hasNext()) {
			if (e2 <= e1) {
				result.add(e2);
				e2 = null;
			}
			result.add(e1);
			while (i1.hasNext()) {
				e1 = i1.next();
				if (e2 != null && e2 <= e1) {
					result.add(e2);
					e2 = null;
				}
				result.add(e1);
			}
		}
			
		if (i2.hasNext()) {
			if (e1 <= e2) {
				result.add(e1);
				e1 = null;
			}
			result.add(e2);
			while (i2.hasNext()) {
				e2 = i2.next();
				if (e1 != null && e1 <= e2) {
					result.add(e1);
					e1 = null;
				}
				result.add(e2);
			}
		}
		
		return result;
	}
	
	public Iterable<Integer> merge(Iterator<Integer> i1, Iterator<Integer> i2) {
		List<Integer> result = new ArrayList<Integer>();
		
		Integer e1 = i1.hasNext() ? i1.next() : null;
		Integer e2 = i2.hasNext() ? i2.next() : null;
		
		while (e1 != null && e2 != null) {
			if (e1 <= e2) {
				result.add(e1);
				e1 = i1.hasNext() ? i1.next() : null;
			} else {
				result.add(e2);
				e2 = i2.hasNext() ? i2.next() : null;
			}
		}
		
		if (e1 != null) {
			result.add(e1);
			while (i1.hasNext()) {
				result.add(i1.next());
			}
		}
		
		if (e2 != null) {
			result.add(e2);
			while (i2.hasNext()) {
				result.add(i2.next());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedIterator m = new MergeTwoSortedIterator();
		
		List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
         
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
         
        Iterable<Integer> result = m.merge(a.iterator(), b.iterator());
         
        for (Integer num : result) {
            System.out.println(num);
        }
    }
}
