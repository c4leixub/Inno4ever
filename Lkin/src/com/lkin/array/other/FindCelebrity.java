package com.lkin.array.other;

import java.util.LinkedList;
import java.util.Queue;

public class FindCelebrity {

	/**
	 * Given a API knows(a, b), find the celebrity. A celebrity means Exist x in
	 * [0, n-1], all p not equal x, such that knows(p, x) && !knows(x, p)
	 */
	public int findCelebrity(int n) {
		// find the only possible candidate
        int a = 0;
        for (int i = 1; i < n; ++i) {   
            a = knows(i, a) ? a : i;
        }
        
        // check if a is celebrity
        for (int i = 0; i < n; i++) {
            if (i != a) {
                if (!knows(i, a) || knows(a, i)) {
                    return -1;
                }
            }
        }
        
        return a;
	}

	public boolean knows(int a, int b) {
		// return true if a knows b
		return true;
	}
}
