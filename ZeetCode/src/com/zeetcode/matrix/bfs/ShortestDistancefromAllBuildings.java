package com.zeetcode.matrix.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at
 * (0,2): 
 * 1 - 0 - 2 - 0 - 1 
 * 0 - 0 - 0 - 0 - 0 
 * 0 - 0 - 1 - 0 - 0 T
 * The point (1,2)
 * is an ideal empty land to build a house, as the total travel distance of
 * 3+3+1=7 is minimal. So return 7.
 * There will be at least one building. If it is not possible to build such
 * house according to the above rules, return -1. */
public class ShortestDistancefromAllBuildings {

	private int[][] positions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 },
			{ 0, 1 } };

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		int m = grid.length, n = grid[0].length;
		int building = 0;

		int[][] distance = new int[m][n];
		int[][] nums = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					building++;
					bfs(grid, distance, nums, i, j);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && nums[i][j] == building) {
					min = Math.min(min, distance[i][j]);
				}
			}
		}

		// handle special cases
		if (min == Integer.MAX_VALUE) {
			return -1;
		}

		return min;
	}

	// similar to level order print
	public void bfs(int[][] grid, int[][] distance, int[][] nums, int i, int j) {

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		Queue<int[]> q1 = new LinkedList<int[]>();
		Queue<int[]> q2 = new LinkedList<int[]>();

		q1.add(new int[] { i, j });
		visited[i][j] = true;
		int d = 0;
		nums[i][j]++;

		while (!q1.isEmpty()) {
			d += 1;
			while (!q1.isEmpty()) {
				int[] cur = q1.poll();
				for (int[] pos : positions) {
					int x = cur[0] + pos[0], y = cur[1] + pos[1];
					if (0 <= x && x < grid.length && 0 <= y
							&& y < grid[0].length && !visited[x][y]
							&& grid[x][y] == 0) {
						distance[x][y] += d;
						nums[x][y]++;
						q2.add(new int[] { x, y });
						visited[x][y] = true;
					}
				}
			}

			Queue<int[]> t = q1;
			q1 = q2;
			q2 = t;
		}
	}
}
