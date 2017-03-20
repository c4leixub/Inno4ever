package com.zeetcode.matrix.bfs;

import java.util.PriorityQueue;

/** Given the following 3x6 height map, return 4
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1] */
public class TrapInWaterII {
	
	private int[][] position = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public class Cell implements Comparable<Cell>{
		int row;
		int col;
		int height;

		public Cell(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}

		@Override
		public int compareTo(Cell o) {
			return this.height - o.height;
		}
	}

	public int trapRainWater(int[][] heights) {
		if (heights == null || heights.length == 0 || heights[0].length == 0)
			return 0;

		PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
		int m = heights.length, n = heights[0].length;
		boolean[][] visited = new boolean[m][n];

		// Initially, add all the Cells which are on borders to the queue.
		for (int i = 0; i < m; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;
			queue.offer(new Cell(i, 0, heights[i][0]));
			queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
		}
		for (int i = 0; i < n; i++) {
			visited[0][i] = true;
			visited[m - 1][i] = true;
			queue.offer(new Cell(0, i, heights[0][i]));
			queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
		}

		int count = 0;
		Cell c;
		while (!queue.isEmpty()) {
			Cell cur = queue.poll();
			for (int[] pos : position) {
				int x = cur.row + pos[0], y = cur.col + pos[1];
				if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y]) {
					visited[x][y] = true;
					if (cur.height - heights[x][y] > 0) {
						count += (cur.height - heights[x][y]);
					}
					c = new Cell(x, y, Math.max(heights[x][y], cur.height));
					queue.offer(c);
				}
			}
		}

		return count;
	}
	
	public static void main(String[] args) {
		TrapInWaterII a = new TrapInWaterII();
//		int[][] heights = new int[][] {
//				{1,4,3,1,3,2},
//				{3,2,1,3,2,4},
//				{2,3,3,2,3,1}
//		};
		
		int[][] heights = new int[][] { 
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 4, 3, 1 }, 
				{ 1, 3, 2, 3, 1 },
				{ 1, 3, 3, 3, 1 },
				{ 1, 1, 1, 1, 1 },
		};
		
		System.out.println(a.trapRainWater(heights));
	}
}
