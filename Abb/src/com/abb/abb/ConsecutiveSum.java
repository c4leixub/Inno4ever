package com.abb.abb;

/**
 * O(sqrt(n)) 对于一个正整数N，能写成K个连续正整数相加的形式，则有
 * 
 * N=(x+1)+(x+2)+…+(x+K) ==> N=K∗x+(1+K)∗K2
 * 
 * 于是，N能够写成K个连续正整数相加的条件是，(N − K∗(K+1)/2) 能够被K整除。
 * 
 * 时间复杂度分析：K个连续正整数相加，K的取值从1开始，且满足(N−K∗(K+1)/2)大于等于0
 * K的可取值范围为sqrt(n)量级。
 * 
 */
public class ConsecutiveSum {

	public int consecutiveNumbersSum(int N) {

		int result = 0;
		for (int k = 1; k * (k + 1) <= 2 * N; k++) {
			if ((N - k * (k + 1) / 2) % k == 0) {
				result++;
			}
		}

		return result;
	}
}
