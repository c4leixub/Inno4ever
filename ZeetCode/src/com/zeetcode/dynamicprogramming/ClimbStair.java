package com.zeetcode.dynamicprogramming;

/**
 * You are climbing a stair case. 
 * It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbStair {
	public int climbStairs(int n) {
		if (n <= 0)
			return 0;
		int p1 = 1, p2 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = p1 + p2;
			p1 = p2;
			p2 = temp;
		}
		return p2;
	}
}
