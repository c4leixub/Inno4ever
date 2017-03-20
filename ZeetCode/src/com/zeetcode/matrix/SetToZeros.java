package com.zeetcode.matrix;

/**
 * There's an integer materials implemented in 2D array. 
 * When met a 0 in any position , change the whole row 
 * and column of that position into 0s  
 */
public class SetToZeros {
	public static void setZeros(int[][] A) {
		boolean[] row = new boolean[A.length];
		boolean[] col = new boolean[A[0].length];
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < col.length; j++) {
				if (row[i] || col[j]) {
					A[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] A = new int[][] {
				{0, 0, 1, 0, 0, 1},
				{1, 1, 1, 1, 1, 1},
				{0, 1, 1, 1, 0, 1},
				{0, 1, 0, 0, 1, 1}
			};
		setZeros(A);
	}
}
