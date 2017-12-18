package com.zeetcode.aalk.array;

import java.util.LinkedList;
import java.util.Queue;

public class FindCelebrity {

	/**
	 * Given a API knows(a, b), find the celebrity. A celebrity means Exist x in
	 * [0, n-1], all p not equal x, such that knows(p, x) && !knows(x, p)
	 */
	public int findCelebrity(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			q.add(i);
		}
		
		// isolate to a candidate
		while (q.size() > 1) {
			Integer a = q.poll();
			Integer b = q.poll();
			
			// determine whether a or b is possible candidate
			if (knows(a, b)) {
				q.add(b);	
			} else {
				q.add(a);
			}
		}

		// celebrity check
		int target = q.poll();
		for (int i = 0; i < n; i++) {
			if (i != target && !(knows(i, target) && !knows(target, i))) {
				return -1;
			}
		}

		return target;
	}

	public boolean knows(int a, int b) {
		// return true if a knows b
		return true;
	}
}
