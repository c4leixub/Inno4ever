package com.zeetcode.matrix.traversal;

/**	For the given grid, return 3.
0 E 0 0
E 0 W E
0 E 0 0	
Note: Two loop inside the inner if statement, complexity is O(MN).
These two if statement doesn't execute all the time, for example if there is no wall
in the grid, then loop will only excute when i == 0 || j == 0
*/
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int ret = 0;
		int row = grid.length;
		int col = grid[0].length;
		
		int rowCache = 0;
		int[] colCache = new int[col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				if (j == 0 || grid[i][j - 1] == 'W') {
					// compute enemy kill at row i before hit the wall
					rowCache = 0;
					for (int k = j; k < col && grid[i][k] != 'W'; k++) {
						rowCache += grid[i][k] == 'E' ? 1 : 0;
					}
				}
				
				if (i == 0 || grid[i - 1][j] == 'W') {
					// compute enemy kill at col j before hit the wall
					colCache[j] = 0;
					for (int k = i; k < row && grid[k][j] != 'W'; k++) {
						colCache[j] += grid[k][j] == 'E' ? 1 : 0;
					}
				}
				
				if (grid[i][j] == '0') {
					ret = Math.max(ret, rowCache + colCache[j]);
				}
			}
		}
		return ret;
	}

	public int maxKilledEnemiesMine(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int ret = 0;
		int row = grid.length;
		int col = grid[0].length;
		
		int[][] kills = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] != 'E') continue;
				
				int k = i+1;
				while (k < row && grid[k][j] != 'W') {
				    if (grid[k][j] == '0') kills[k][j] += 1;
				    k++;
				}
				
				k = i-1;
				while (k >= 0 && grid[k][j] != 'W') {
				    if (grid[k][j] == '0') kills[k][j] += 1;
				    k--;
				}
				
				k = j+1;
				while (k < col && grid[i][k] != 'W') {
				    if (grid[i][k] == '0') kills[i][k] += 1;
				    k++;
				}
				
				k = j-1;
				while (k >= 0 && grid[i][k] != 'W') {
				    if (grid[i][k] == '0') kills[i][k] += 1;
				    k--;
				}
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
			    ret = Math.max(ret, kills[i][j]);
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		char[][] grid = new char[][] {
				"0E00".toCharArray(),
				"E0WE".toCharArray(),
				"0E00".toCharArray()
		};
		BombEnemy b = new BombEnemy();
		System.out.println(b.maxKilledEnemiesMine(grid));
	}
}
