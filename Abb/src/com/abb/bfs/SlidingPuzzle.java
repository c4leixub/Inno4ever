package com.abb.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

	class Node {
		String boardStr;
		int[] index;

		public Node(String boardStr, int[] index) {
			this.boardStr = boardStr;
			this.index = index;
		}
	}

	private int[][] DIRECTION = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	/**
	 * Time Complexity: O(R * C * (R * C)!) where R, CR,C are the
	 * number of rows and columns in board. There are O((R∗C)!) possible
	 * board states.
	 * 
	 * Space Complexity: O(R * C * (R * C)!)
	 */
	public int slidingPuzzle(int[][] board, String correct) {
		int row = board.length, col = board[0].length;

		// build the string version of the board
		StringBuilder boardSB = new StringBuilder();
		int x = -1, y = -1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 0) {
					x = i;
					y = j;
				}
				boardSB.append(board[i][j]);
			}
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(boardSB.toString(), new int[] { x, y }));

		int res = 0;
		Set<String> visited = new HashSet<String>();

		Node node;
		String boardStr;
		int[] index;
		while (!queue.isEmpty()) {
			int size = queue.size(); // only loop the existing element in the queue
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				boardStr = node.boardStr;
				index = node.index;
				if (boardStr.equals(correct))
					return res;

				visited.add(boardStr);

				for (int[] dir : DIRECTION) {
					x = index[0] + dir[0];
					y = index[1] + dir[1];
					if (x < 0 || x >= row || y < 0 || y >= col) {
						continue;
					}

					StringBuilder candidate = new StringBuilder(boardStr);

					// swap
					char t = candidate.charAt(index[0] * col + index[1]);
					candidate.setCharAt(index[0] * col + index[1], candidate.charAt(x * col + y));
					candidate.setCharAt(x * col + y, t);

					if (visited.contains(candidate.toString())) {
						continue;
					}
					queue.add(new Node(candidate.toString(), new int[] { x, y }));
				}
			}
			res++;
		}

		return -1;
	}

	public static void main(String[] args) {
		SlidingPuzzle s = new SlidingPuzzle();

		int[][] board = new int[][] { { 1, 2, 3 }, { 4, 0, 5 } };
		System.out.println(s.slidingPuzzle(board, "123450"));

		board = new int[][] { { 1, 2, 3 }, { 5, 4, 0 } };
		System.out.println(s.slidingPuzzle(board, "123450"));

		board = new int[][] { { 4, 1, 2 }, { 5, 0, 3 } };
		System.out.println(s.slidingPuzzle(board, "123450"));

		board = new int[][] { { 3, 2, 4 }, { 1, 5, 0 } };
		System.out.println(s.slidingPuzzle(board, "123450"));

		board = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
		System.out.println(s.slidingPuzzle(board, "123456780"));
	}
}
