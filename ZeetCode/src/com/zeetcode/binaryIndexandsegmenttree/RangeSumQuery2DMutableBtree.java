package com.zeetcode.binaryIndexandsegmenttree;

public class RangeSumQuery2DMutableBtree {

	int[][] btrees;
	int m;
	int n;
	int[][] matrix;

	public RangeSumQuery2DMutableBtree(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		this.matrix = matrix;
		m = matrix.length;
		n = matrix[0].length;
		btrees = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				add(i + 1, j + 1, this.matrix[i][j]);
			}
		}
	}

	// O(log m * n)
	private void add(int btreeRow, int btreeCol, int val) {
		for (int i = btreeRow; i < btrees.length; i = i + (i & (-i))) {
			for (int j = btreeCol; j < btrees[i].length; j = j + (j & (-j))) {
				btrees[i][j] += val;
			}
		}
	}

	public void update(int row, int col, int val) {
		if (matrix == null)
			return;

		int diff = val - matrix[row][col];
		add(row + 1, col + 1, diff);
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1)
				+ sum(row1, col1);
	}

	// Returns the sum from (0,0) to (x, y) where x=btreeRow-1, y=btreeCol-1 (O(log m * n)
	public int sum(int btreeRow, int btreeCol) {
		int sum = 0;
		for (int i = btreeRow; i >= 1; i = i - (i & (-i))) {
			for (int j = btreeCol; j >= 1; j = j - (j & (-j))) {
				sum += btrees[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 3, 0, 1, 4, 2 }, 
				{ 5, 6, 3, 2, 1 },
				{ 1, 2, 0, 1, 5 }, 
				{ 4, 1, 0, 1, 7 }, 
				{ 1, 0, 3, 0, 5 } };
		RangeSumQuery2DMutableBtree r = new RangeSumQuery2DMutableBtree(matrix);
		System.out.println(r.sum(5, 4));
		System.out.println(r.sum(2, 4));
		System.out.println(r.sum(5, 1));
		System.out.println(r.sum(2, 1));
		System.out.println(r.sumRegion(2, 1, 4, 3));
		
	}
}
