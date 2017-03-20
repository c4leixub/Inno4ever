package com.zeetcode.matrix.traversal;

public class LongestIncreasePath {

	int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] mem = new int[matrix.length][matrix[0].length];
		int max = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				max = Math.max(max, dfs(matrix, i, j, mem));
			}
		}

		return max;
	}

	public int dfs(int[][] matrix, int i, int j, int[][] mem) {
		if (mem[i][j] != 0) {
			return mem[i][j];
		}

		for (int r = 0; r < 4; r++) {
			int x = i + directions[r][0];
			int y = j + directions[r][1];

			if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length
					&& matrix[x][y] > matrix[i][j]) {
				mem[i][j] = Math.max(mem[i][j], dfs(matrix, x, y, mem));
			}
		}

		mem[i][j]++;
		return mem[i][j];
	}

	public static void main(String[] args) {

		LongestIncreasePath l = new LongestIncreasePath();
		int[][] nums = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(l.longestIncreasingPath(nums));
	}
}
