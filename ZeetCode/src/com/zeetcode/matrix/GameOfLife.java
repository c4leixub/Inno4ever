package com.zeetcode.matrix;

/** Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the 
 * following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
 */
public class GameOfLife {

	private static final int DEAD = 0;
	private static final int LIVE = 1;
	private static final int LIVE_TO_LIVE = 2;
	private static final int DEAD_TO_LIVE = 3;
	private static final int LIVE_TO_DEAD = 4;
	
	private final static int[][] DIRECTIONS = new int[][] {
			{ -1, 0 },{ 1, 0 }, { 0, -1 }, { 0, 1 },
			{ -1, -1 }, { 1, 1 }, { -1, 1 },{ 1, -1 } };
	
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int lives = findLiveNeighbors(i, j, board);
				
				if (board[i][j] == 0) {
					if (lives == 3) {
						board[i][j] = DEAD_TO_LIVE;
					}
				} else if (lives >= 2 && lives <= 3) {
					board[i][j] = LIVE_TO_LIVE;
				} else {
					board[i][j] = LIVE_TO_DEAD;
				}
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = getNextState(board[i][j]);
			}
		}
	}

	public int findLiveNeighbors(int i, int j, int[][] board) {
		int count = 0, x, y;
		for (int[] direction : DIRECTIONS) {
			x = i + direction[0];
			y = j + direction[1];

			if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
				continue;
			}
			
			int liveOrDead = getPreState(board[x][y]);	//board[i][j];
			if (liveOrDead == LIVE) {
				count++;
			}
		}

		return count;
	}
	
	public int getPreState(int i) {
		if (i == DEAD || i == LIVE)	return i;
		if (i == LIVE_TO_LIVE || i == LIVE_TO_DEAD)	return LIVE;
		return DEAD;
	}
	
	public int getNextState(int i) {
		if (i == LIVE_TO_LIVE || i == DEAD_TO_LIVE)	return LIVE;
		return DEAD;
	}
	
	
}
