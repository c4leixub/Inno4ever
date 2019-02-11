package com.lkin.matrix.dfs;

public class WordSearch {

	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		visited = new boolean[m][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int w) {
		int m = board.length, n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
			return false;
		}

		if (w == word.length() - 1 && board[i][j] == word.charAt(w)) {
			return true;
		}

		visited[i][j] = true;
		if (board[i][j] == word.charAt(w)) {
			for (int[] d : dirs) {
				if (dfs(board, word, i + d[0], j + d[1], w + 1)) {
					return true;
				}
			}
		}
		visited[i][j] = false;

		return false;
	}
}
