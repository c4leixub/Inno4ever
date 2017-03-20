package com.zeetcode.matrix;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinPathSum {

	// dynamic programming solution (faster than DFS)
	public int minPathSum_Dynamic(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];

		// fill the 1st row
		for (int j = 1; j < grid[0].length; j++) {
			dp[0][j] = grid[0][j] + dp[0][j - 1];
		}

		// fill the 1st col
		for (int i = 1; i < grid.length; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		return dp[grid.length - 1][grid[0].length - 1];
	}

	// depth first solution
	public int minPathSum(int[][] grid) {
		return dfs(0, 0, grid);
	}

	public int dfs(int i, int j, int[][] grid) {
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}

		if (i < grid.length - 1 && j < grid[0].length - 1) {
			int s1 = grid[i][j] + dfs(i + 1, j, grid);
			int s2 = grid[i][j] + dfs(i, j + 1, grid);
			return Math.min(s1, s2);
		}

		if (i < grid.length - 1) { // at the last col, but not last row
			return grid[i][j] + dfs(i + 1, j, grid);
		}

		if (j < grid[0].length - 1) { // at the last row, but not last col
			return grid[i][j] + dfs(i, j + 1, grid);
		}

		return 0;
	}

}
