package com.zeetcode.binaryIndexandsegmenttree;

public class RangeSumQuery2D {

	int[][] sum;

	public RangeSumQuery2D(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		int m = matrix.length, n = matrix[0].length;
		sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			int sumRow = 0;
			for (int j = 0; j < n; j++) {
				sumRow += matrix[i][j];
				if (i == 0) {					
					sum[i][j] = sumRow;
				} else {
					sum[i][j] = sumRow + sum[i-1][j];
				}
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (this.sum == null)
			return 0;
		
		int topRightX = row1, topRightY = col2;
		int bottomLeftX = row2, bottomLeftY = col1;
		
		if (row1 == 0 && col1 == 0) {
			return sum[row2][col2];
		} else if (row1 == 0) {
			return sum[row2][col2] - sum[bottomLeftX][bottomLeftY-1];
		} else if (col1 == 0) {
			return sum[row2][col2] - sum[topRightX-1][topRightY];
		}
		
		return sum[row2][col2] - sum[topRightX-1][topRightY]
					- sum[bottomLeftX][bottomLeftY-1] + sum[row1-1][col1-1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 1, 2, 3}, 
				{ 4, 5, 6},
				{ 7, 8, 9}};
		RangeSumQuery2D r = new RangeSumQuery2D(matrix);
		int[][] sum = r.sum;
	}
}
