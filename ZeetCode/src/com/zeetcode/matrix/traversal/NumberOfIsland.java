package com.zeetcode.matrix.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2-d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water. Example 1
 * 
 * 11110 11010 11000 00000 Answer: 1
 */
public class NumberOfIsland {
	private int[][] DIRECTION = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
	
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
	}
	private void dfs(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for (int[] direction : DIRECTION) {
            dfs(grid, m, n, i + direction[0], j + direction[1]);
        }
    }

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		int[] rootArray = new int[m * n];
		Arrays.fill(rootArray, -1);

		List<Integer> result = new ArrayList<Integer>();
		int count = 0;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int k = 0; k < positions.length; k++) {
			count++;

			int[] p = positions[k];
			int index = p[0] * n + p[1];
			rootArray[index] = index;// set root to be itself for each node

			for (int r = 0; r < 4; r++) {
				int i = p[0] + directions[r][0];
				int j = p[1] + directions[r][1];

				if (0 <= i && i < m && 0 <= j  && j < n	
						&& rootArray[i * n + j] != -1) {
					
					// get neighbor's root
					int thisRoot = getRoot(rootArray, i * n + j);
					if (thisRoot != index) {
						rootArray[thisRoot] = index;// set previous root's root
						count--;
					}
				}
			}

			result.add(count);
		}

		return result;
	}

	public int getRoot(int[] arr, int i) {
		while (i != arr[i]) {
			i = arr[i];
		}
		return i;
	}

	public static void main(String[] args) {
		NumberOfIsland s = new NumberOfIsland();
		int[][] positions = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 2 },
				{ 2, 1 } };
		System.out.println(s.numIslands2(3, 3, positions));
	}
}
