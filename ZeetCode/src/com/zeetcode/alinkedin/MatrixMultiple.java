package com.zeetcode.alinkedin;

public class MatrixMultiple {
	public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 ||
            B == null || B.length == 0) {
            return new int[0][0];    
        }
        
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                //if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        //if (B[k][j] != 0) 
                            C[i][j] += A[i][k] * B[k][j];
                    }
                //}
            }
        }
        return C; 
    }
}
