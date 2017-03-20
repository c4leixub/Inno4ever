package com.zeetcode.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AndroidUnlockPattern {
	
	private static Map<Integer, Map<Integer, Integer>> STEP_REQ = new HashMap<Integer, Map<Integer, Integer>>();
	static {
		for (int elem = 1; elem <= 9; elem++) {
			STEP_REQ.put(elem, new HashMap<Integer, Integer>());
		}
		
		STEP_REQ.get(1).put(3, 2);
		STEP_REQ.get(1).put(7, 4);
		STEP_REQ.get(1).put(9, 5);
		
		STEP_REQ.get(2).put(8, 5);
		
		STEP_REQ.get(3).put(1, 2);
		STEP_REQ.get(3).put(7, 5);
		STEP_REQ.get(3).put(9, 6);
		
		STEP_REQ.get(4).put(6, 5);
		
		STEP_REQ.get(6).put(4, 5);
		
		STEP_REQ.get(7).put(1, 4);
		STEP_REQ.get(7).put(3, 5);
		STEP_REQ.get(7).put(9, 8);
		
		STEP_REQ.get(8).put(2, 5);
		
		STEP_REQ.get(9).put(1, 5);
		STEP_REQ.get(9).put(3, 6);
		STEP_REQ.get(9).put(7, 8);
	}
	
	public int numberOfPatterns(int m, int n) {
		int[] res = new int[1];
		helper(0, 0, m, n, new HashSet<Integer>(), res);
		return res[0];
	}

	public void helper(int cur, int pos, int m, int n, Set<Integer> visited, int[] res) {
		if (pos >= m) {
			res[0]++;
			if (pos == n)	return;
		}

		for (int elem = 1; elem <= 9; elem++) {
			if (visited.contains(elem)) continue;
			
			if (STEP_REQ.get(cur).get(elem) != null
					&& !visited.contains(STEP_REQ.get(cur).get(elem))) {
				continue;
			}
			
//			if (cur == 1) {
//				if (elem == 3 && !visited.contains(2))
//					continue;
//				if (elem == 7 && !visited.contains(4))
//					continue;
//				if (elem == 9 && !visited.contains(5))
//					continue;
//
//			} else if (cur == 2) {
//				if (elem == 8 && !visited.contains(5))
//					continue;
//
//			} else if (cur == 3) {
//				if (elem == 1 && !visited.contains(2))
//					continue;
//				if (elem == 7 && !visited.contains(5))
//					continue;
//				if (elem == 9 && !visited.contains(6))
//					continue;
//
//			} else if (cur == 4) {
//				if (elem == 6 && !visited.contains(5))
//					continue;
//
//			} else if (cur == 6) {
//				if (elem == 4 && !visited.contains(5))
//					continue;
//
//			} else if (cur == 7) {
//				if (elem == 1 && !visited.contains(4))
//					continue;
//				if (elem == 3 && !visited.contains(5))
//					continue;
//				if (elem == 9 && !visited.contains(8))
//					continue;
//
//			} else if (cur == 8) {
//				if (elem == 2 && !visited.contains(5))
//					continue;
//
//			} else if (cur == 9) {
//				if (elem == 1 && !visited.contains(5))
//					continue;
//				if (elem == 3 && !visited.contains(6))
//					continue;
//				if (elem == 7 && !visited.contains(8))
//					continue;
//
//			}

			visited.add(elem);
			helper(elem, pos + 1, m, n, visited, res);
			visited.remove(elem);
		}

	}
}
