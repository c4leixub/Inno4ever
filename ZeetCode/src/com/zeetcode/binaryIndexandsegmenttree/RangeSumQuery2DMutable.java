package com.zeetcode.binaryIndexandsegmenttree;

public class RangeSumQuery2DMutable {
	
	private int[][] rowSums;
	
	public RangeSumQuery2DMutable(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		
		int m = matrix.length, n = matrix[0].length;
		rowSums = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				rowSums[i][j] = matrix[i][j] + (j == 0 ? 0 : rowSums[i][j-1]);
			}
		}
		
	}
	
	public void update(int row, int col, int val) {
        if (rowSums == null)
        	return;
		
		int preVal = col == 0 ? rowSums[row][col]: rowSums[row][col] - rowSums[row][col-1];
		int diff = val - preVal;
		
		for (int j = col; j < rowSums[row].length; j++) {
			rowSums[row][j] += diff;
		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (rowSums == null)
        	return 0;
    	
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
        	if (col1 == 0) {
        		sum += rowSums[i][col2];
        	} else {
        		sum += rowSums[i][col2] - rowSums[i][col1-1];
        	}
        }
        return sum;
    }
}
