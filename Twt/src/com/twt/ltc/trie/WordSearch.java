package com.twt.ltc.trie;

public class WordSearch {
	
	int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int k) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}

		if (board[i][j] == word.charAt(k)) {
			char c = board[i][j];
			board[i][j] = '#';
			if (k == word.length() - 1) {
				return true;
			} else {
				for (int[] d : direction) {
					if (dfs(board, i + d[0], j + d[1], word, k + 1)) {
						return true;
					}
				}
			}
			board[i][j] = c;
		}

		return false;
	}
}
