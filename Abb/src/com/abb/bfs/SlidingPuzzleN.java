package com.abb.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzleN {

	class Node {
		List<Integer> boardList;
		int[] index; // the index of 0

		public Node(List<Integer> boardList, int[] index) {
			this.boardList = boardList;
			this.index = index;
		}
	}

	private int[][] DIRECTION = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private int row, col;
	private int x0, y0;

	private List<Integer> solvedBoardList;
	private List<Integer> curBoardList;

	public SlidingPuzzleN(int[][] board) {
		row = board.length;
		col = board[0].length;

		int s = 1;
		solvedBoardList = new ArrayList<Integer>();
		curBoardList = new ArrayList<Integer>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 0) {
					x0 = i;
					y0 = j;
				}
				curBoardList.add(board[i][j]);

				if (i == row - 1 && j == col - 1) {
					solvedBoardList.add(0);
				} else {
					solvedBoardList.add(s);
					s++;
				}
			}
		}
	}

	public int canSolve() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(curBoardList, new int[] { x0, y0 }));

		int res = 0;
		Set<List<Integer>> visited = new HashSet<List<Integer>>();

		Node node;
		List<Integer> boardList;
		int[] index;
		while (!queue.isEmpty()) {
			int size = queue.size(); // only loop the existing element in the queue
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				boardList = node.boardList;
				index = node.index;
				if (boardList.equals(solvedBoardList))
					return res;

				visited.add(boardList);

				for (int[] dir : DIRECTION) {
					int x = index[0] + dir[0], y = index[1] + dir[1];
					if (x < 0 || x >= row || y < 0 || y >= col) {
						continue;
					}

					List<Integer> candidate = new ArrayList<>(boardList);

					// swap
					Integer t = candidate.get(index[0] * col + index[1]);
					candidate.set(index[0] * col + index[1], candidate.get(x * col + y));
					candidate.set(x * col + y, t);

					if (visited.contains(candidate)) {
						continue;
					}

					queue.add(new Node(candidate, new int[] { x, y }));
				}
			}
			res++;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 1, 2, 3 }, { 4, 0, 5 } };
		SlidingPuzzleN s = new SlidingPuzzleN(board);
		System.out.println(s.canSolve());

		List<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(0);

		List<Integer> abc = new ArrayList<Integer>();
		abc.add(1);
		abc.add(2);
		abc.add(3);
		abc.add(4);
		abc.add(5);
		abc.add(0);

		Set<List<Integer>> ss = new HashSet<>();
		ss.add(abc);
		//System.out.println(ss.contains(test));

		board = new int[][] { { 1, 2, 3 }, { 5, 4, 0 } };
		s = new SlidingPuzzleN(board);
		System.out.println(s.canSolve());

		board = new int[][] { { 4, 1, 2 }, { 5, 0, 3 } };
		s = new SlidingPuzzleN(board);
		System.out.println(s.canSolve());
		
		board = new int[][] { { 3, 2, 4 }, { 1, 5, 0 } };
		s = new SlidingPuzzleN(board);
		System.out.println(s.canSolve());

		board = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
		s = new SlidingPuzzleN(board);
		System.out.println(s.canSolve());
	}
}
