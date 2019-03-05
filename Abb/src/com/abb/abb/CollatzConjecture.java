package com.abb.abb;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目是给你公式，比如偶数的话除 2，奇数的话就变成 3*n+1，对于任何一个正数，数学猜想是最终他会变成 1
 * 每变一步步数加1，给一个上限，让找出范围内最长步数。 比如 7，变换到 1
 * 是如下顺序:7->22->11->34->17->52->26->13->40->20->10->5->16->8->4->2->1, 总 共需要 17
 * 步。
 *
 */
public class CollatzConjecture {

	private Map<Long, Integer> map = new HashMap<>();

	private int findSteps(long num) {
		if (num == 1) return 1;
		if (map.containsKey(num)) return map.get(num); 
		
		int steps = 1;
		while (num != 1) {
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = 3 * num + 1;
			}
			//System.out.println(num);
			steps++;
		}
		
		return steps;
	}
	
	public int findLongestSteps(long num) {
		if (num < 1) return 0;
		int res = 0;
		
		for (long i = 1; i <= num; i++) {
			int t = findSteps(i);
			map.put(i, t);
			res = Math.max(res, t);
		}
		return res;
	}
	
	public static void main(String[] args) {
		CollatzConjecture c = new CollatzConjecture();
		System.out.println(c.findLongestSteps(837799));
	}
}
