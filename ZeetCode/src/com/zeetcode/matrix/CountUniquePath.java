package com.zeetcode.matrix;

public class CountUniquePath {

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;

		// fill the 1st row
		for (int j = 1; j < n; j++) {
			dp[0][j] = 1;
		}

		// fill the 1st col
		for (int i = 1; i < m; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		
		return dp[m-1][n-1];
	}
	
	private static final int OBSTACLE = 1;
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == OBSTACLE ? 0 : 1;

		// fill the 1st row
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == OBSTACLE || dp[0][j - 1] == 0) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = 1;
			}
		}

		// fill the 1st col
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == OBSTACLE || dp[i - 1][0] == 0) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = 1;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == OBSTACLE) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		
		return dp[m-1][n-1];
    }
}
