package com.zeetcode.dp;

import java.util.Arrays;

public class PerfectSquare {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}

		for (int a = 0; a <= n; a++) {
			for (int b = 0; a + b * b <= n; b++) {
				dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
			}
		}

		return dp[n];
	}
}
