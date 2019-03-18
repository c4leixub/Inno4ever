package com.lkin.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import com.common.structs.Interval;

public class RangeModuleTreeSet {
	
	private TreeSet<Interval> ranges;
	
    public RangeModuleTreeSet() {
        ranges = new TreeSet<Interval>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.end == o2.end) return o1.start - o2.start;
		        return o1.end - o2.end;
			}
        	
        });
    }

    // Let K be the number of elements in ranges, O(K)complexity.
    public void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.start) break;
            left = Math.min(left, iv.start);
            right = Math.max(right, iv.end);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    // O(logK)
    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.start <= left && right <= iv.end);
    }

    // Let K be the number of elements in ranges, O(K)complexity.
    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.start) break;
            if (iv.start < left) todo.add(new Interval(iv.start, left));
            if (right < iv.end) todo.add(new Interval(right, iv.end));
            itr.remove();
        }
        for (Interval iv: todo) ranges.add(iv);
    }
}

//class Interval {
//    int start;
//    int end;
//
//    public Interval(int left, int right){
//        this.start = left;
//        this.end = right;
//    }
//
////    public int compareTo(Interval that){
////        if (this.right == that.right) return this.left - that.left;
////        return this.right - that.right;
////    }
//
//}
