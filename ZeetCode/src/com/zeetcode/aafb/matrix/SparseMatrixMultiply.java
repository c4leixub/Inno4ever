package com.zeetcode.aafb.matrix;

public class SparseMatrixMultiply {
	public int[][] multiply(int[][] A, int[][] B) {

		int rowA = A.length, colA = A[0].length, colB = B[0].length;
		int[][] re = new int[rowA][colB];

		for (int i = 0; i < rowA; i++) {
			for (int k = 0; k < colA; k++) {

				if (A[i][k] != 0) {

					for (int j = 0; j < colB; j++) {

						if (B[k][j] != 0) {
							re[i][j] += A[i][k] * B[k][j];
						}
					}
				}
			}
		}

		return re;
	}
}
