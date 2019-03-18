package com.lkin.dp;

public class ProfitScheme {
	
	// Time: O(N*P*G), space: O(P*G)
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		int MOD = (int) 1e9 + 7;
		long[][] dp = new long[G + 1][P + 1];
		dp[0][0] = 1;
		for (int ii = 0; ii < group.length; ++ii) {
			int g = group[ii], p = profit[ii];
			for (int r = G; r >= g; --r) {
				long sum0 = dp[r][P];
				for (int c = Math.max(0, P - p); c <= P; ++c) {
					sum0 = (sum0 + dp[r - g][c]) % MOD;
				}
				dp[r][P] = sum0;
				for (int c = P - 1; c >= p; --c) {
					dp[r][c] = (dp[r][c] + dp[r - g][c - p]) % MOD;
				}
			}
		}
		long ret = 0;
		for (int i = 0; i <= G; ++i)
			ret = (ret + dp[i][P]) % MOD;
		return (int) ret;
	}
}
