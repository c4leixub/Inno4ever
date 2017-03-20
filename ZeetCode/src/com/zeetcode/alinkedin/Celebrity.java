package com.zeetcode.alinkedin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You have a room with n people. A celebrity walks in. 
 * Everyone knows the celebrity, the celebrity knows no one. 
 * Non-celebrities may/may not know anyone in the room. 
 * Give an algorithm to find the celebrity. Discuss the complexity.
 */
public class Celebrity {

	private boolean[][] matrix;
	private int numberOfPerson;
	
	private Celebrity(boolean[][] m) {
		this.matrix = m;
		numberOfPerson = matrix.length;
	}
	
	private boolean knows(int a, int b) {
		return matrix[a][b];
	}
	
	public int findCelebrity(int n) {
        if (n <= 1) return -1;
        
        int l = 0, r = n - 1;
        while (l < r) {
            if (knows(l, r)) {
                l++;
            } else {
                r--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i != l) {
                if (knows(l, i) || !knows(i, l)) return -1;
            }
        }
        return l;
	}
	
	public int findCelebrity() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numberOfPerson; i++) {
			q.add(i);
		}
		
		while (q.size() > 1) {
			Integer a = q.poll();
			Integer b = q.poll();
			
			if (knows(a, b)) {
				q.add(b);
			} else {
				q.add(a);
			}
		}
		
		Integer c = q.poll();
		System.out.println("Potential candidate " + c);
		for (int i = 0; i < numberOfPerson; i++) {
			if (i != c && !(knows(i, c) && !knows(c, i)) ) {
				return -1;
			}
		}
		
		
		return c;
	}
	
	
	public static void main(String[] args) {
		boolean[][] matrix = {	{false, true, true, true}, 
								{true, false, true, true},
								{false, false, false, false}, 
								{false, false, true, false}
							};
		
		Celebrity c = new Celebrity(matrix);
		System.out.println(c.findCelebrity());
		System.out.println(c.findCelebrity(4));
	
	}

}
