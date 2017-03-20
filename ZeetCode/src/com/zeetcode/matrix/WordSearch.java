package com.zeetcode.matrix;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean dfs(char[][] board, String word, int i, int j, int k) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}

		if (board[i][j] == word.charAt(k)) {
			/*	for non repeat use of i,j
			if (k == 0) {	
				board = newBoard(board);
			}*/
			
			char temp = board[i][j]; 
			board[i][j] = '#';
			if (k == word.length() - 1) {
				return true;
			} else if (dfs(board, word, i - 1, j, k + 1)
						|| dfs(board, word, i + 1, j, k + 1)
						|| dfs(board, word, i, j - 1, k + 1)
						|| dfs(board, word, i, j + 1, k + 1)) {
				return true;
			}
			board[i][j] = temp;
		}

		return false;
	}

	public static char[][] newBoard(char[][] board) {
		char[][] newBoard = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		// System.out.println(WordSearch.exist(board, "ABCCED"));
		// System.out.println(WordSearch.exist(board, "SEE"));
		System.out.println(WordSearch.exist(board, "ABCB"));
	}
}
