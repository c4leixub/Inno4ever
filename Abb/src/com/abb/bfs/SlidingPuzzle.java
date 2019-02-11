package com.abb.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

	private int[][] DIRECTION = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

	public int slidingPuzzle(int[][] board) {

		String correct = "123450";
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
		queue.add(new Node(boardSB.toString(), new int[] {x,y}));
		
		int res = 0;
		Set<String> visited = new HashSet<String>();
		
		Node node;
		String boardStr;
		int[] index;
		while (!queue.isEmpty()) {
			int size = queue.size();	// only loop the existing element in the queue
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				boardStr = node.boardStr;
				index = node.index;
				if (boardStr.equals(correct)) return res;
				
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
					queue.add(new Node(candidate.toString(), new int[] {x,y}));
				}
			}
			res++;
		}

		return -1;
	}
	
	public static void main(String[] args) {
		SlidingPuzzle s = new SlidingPuzzle();
		
		int[][] board = new int[][] {{1,2,3},{4,0,5}};
		System.out.println(s.slidingPuzzle(board));
		
		board = new int[][] {{1,2,3},{5,4,0}};
		System.out.println(s.slidingPuzzle(board));
		
		board = new int[][] {{4,1,2},{5,0,3}};
		System.out.println(s.slidingPuzzle(board));		
		
		board = new int[][] {{3,2,4},{1,5,0}};
		System.out.println(s.slidingPuzzle(board));
		
//		Set<int[][]> visited = new HashSet<int[][]>();
//		int[][] correct = new int[][] { { 1, 2, 3 }, { 4, 5, 0 } };
//		
//		visited.add(correct);
//		System.out.println(visited.contains(correct));
//
//		int[][] test = new int[][] { { 1, 2, 3 }, { 4, 5, 0 } };
//		System.out.println(visited.contains(test));
//		
//		test[0][0] = 11;
//		System.out.println(visited.contains(test));
		
//		Set<List<List<Integer>>> visited = new HashSet<List<List<Integer>>>();
//		List<List<Integer>> correct = new ArrayList<List<Integer>>();
//		correct.add(Arrays.asList(new Integer(1), new Integer(2), new Integer(3)));
//		correct.add(Arrays.asList(new Integer(4), new Integer(5), new Integer(0)));
//
//		visited.add(correct);
//		
//		List<List<Integer>> test = new ArrayList<List<Integer>>();
//		test.add(Arrays.asList(new Integer(1), new Integer(2), new Integer(3)));
//		test.add(Arrays.asList(new Integer(4), new Integer(5), new Integer(0)));
//		
//		System.out.println(visited.contains(test));
//		
//		test.get(0).set(0, 11);
//		System.out.println(visited.contains(test));
	}
}
