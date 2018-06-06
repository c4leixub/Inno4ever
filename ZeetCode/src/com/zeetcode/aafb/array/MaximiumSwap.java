package com.zeetcode.aafb.array;

/**
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * Example 1: Input: 2736 Output: 7236 Explanation: Swap the number 2 and the
 * number 7.
 * 
 * Example 2: Input: 9973 Output: 9973 Explanation: No swap.
 */
public class MaximiumSwap {
	public int maximumSwap(int num) {
		String res = String.valueOf(num);

		char[] back = res.toCharArray();
		for (int i = back.length - 2; i >= 0; i--) {
			back[i] = back[i + 1] > back[i] ? back[i + 1] : back[i];
		}

		char[] resArr = res.toCharArray();
		for (int i = 0; i < back.length; i++) {
			if (resArr[i] == back[i])
				continue;

			for (int j = resArr.length - 1; j > i; j--) {
				if (resArr[j] == back[i]) {

					char t = resArr[i];
					resArr[i] = resArr[j];
					resArr[j] = t;

					return Integer.parseInt(new String(resArr));
				}
			}
		}

		return num;
	}
}
