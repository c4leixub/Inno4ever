package com.zeetcode.design;

public class TicTacToe {

	private int[] rows;
	private int[] cols;
	private int diagonalOne;
	private int diagonalTwo;
	private int[][] matrix;
	private int size;

	private final static int[] VALUES = new int[] { 1, -1 };

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];

		diagonalOne = 0;
		diagonalTwo = 0;

		matrix = new int[n][n];
		size = n;
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int val = VALUES[player - 1];

		rows[row] += val;
		cols[col] += val;

		if (row == col) {
			diagonalOne += val;
		}
		if (col == size - row - 1) {
			diagonalTwo += val;
		}

		if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
				|| Math.abs(diagonalOne) == size
				|| Math.abs(diagonalTwo) == size) {
			return player;
		}

		return 0;
	}

	public int moveSafely(int row, int col, int player) {
		isMoveValid(row, col);
		matrix[row][col] = player;
		return move(row, col, player);
	}

	public boolean isMoveValid(int row, int col) {
		if (row < 0 || row >= size || col < 0 || col >= size) {
			return false;
		}
		if (matrix[row][col] != 0) {
			return false;
		}

		return true;
	}

}
