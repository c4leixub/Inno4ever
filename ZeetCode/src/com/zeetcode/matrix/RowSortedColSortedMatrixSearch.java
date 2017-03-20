package com.zeetcode.matrix;

public class RowSortedColSortedMatrixSearch {
	
	public static boolean stepWiseSearch(int[][] m, int target) {
		if (target < m[0][0]) return false;
		
		int row = m.length;
		int col = m[0].length;
		
		int i = 0, j = col - 1;	// start from upper right
		while (i < row && j >= 0) {
			if (target < m[i][j]) {
				j--;
			} else if (target > m[i][j]) {
				i++;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
