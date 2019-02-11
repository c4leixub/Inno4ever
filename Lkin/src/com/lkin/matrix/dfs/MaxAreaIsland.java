package com.lkin.matrix.dfs;

public class MaxAreaIsland {
	
	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
			
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
            || grid[i][j] == 0) {
            return 0;
        }
        
        grid[i][j] = 0;
        int total = 1;
        
        for (int[] d : dirs) {
            total += dfs(grid, i + d[0], j + d[1]);
        }
        
        return total;
    }
}
