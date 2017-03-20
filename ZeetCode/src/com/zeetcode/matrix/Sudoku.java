package com.zeetcode.matrix;

/**
 * Determine if a Sudoku is valid, 
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'.
 */
public class Sudoku {
	public boolean isValidSudoku(char[][] board) {
		// check rows
		boolean[] occurOnce = new boolean[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.')	{
					int t = board[i][j] - 49;
					if (occurOnce[t]) {
						return false;
					} else {
						occurOnce[t] = true;
					}
				}
			}
			occurOnce = new boolean[9];
		}
		
		// check cols
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.')	{
					int t = board[i][j] - 49;
					if (occurOnce[t]) {
						return false;
					} else {
						occurOnce[t] = true;
					}
				}
			}
			occurOnce = new boolean[9];
		}
		
		// check blocks
		for (int block = 0; block < 9; block++) {
			occurOnce = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.')	{
					    int t = board[i][j] - 49;
					    if (occurOnce[t]) {
						    return false;
					    } else {
						    occurOnce[t] = true;
					    }
				    }
				}
			}
		}
		
//		for (int m = 3; m <= 9; m += 3) {
//			for (int n = 3; n <= 9; n += 3) {
//				if (!isValidSudokuBlock(m-3, n-3, m, n, board)) {
//					return false;
//				}
//			}
//		}
		
		return true;
    }
	
	public boolean isValidSudokuBlock(int i, int j, int m, int n, char[][] board) {
		boolean[] occurOnce = new boolean[9];
		while (i < m) {
			while (j < n) {
				if (board[i][j] != '.')	{
					int t = board[i][j] - 49;
					if (occurOnce[t]) {
						return false;
					} else {
						occurOnce[t] = true;
					}
				}
				j++;
			}
			i++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		//["....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"]
	}
}
