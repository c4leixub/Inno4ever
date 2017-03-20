package com.zeetcode.matrix;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
	
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		int max = 1;
		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) { 
				if (matrix[i][j] == '1') {
					int sz = getSquareSize(matrix, i+1, j+1, 2);
					max = Math.max(max, sz);
				}
			}
		}
		
		return max;
    }
	
	public int getSquareSize(char[][] m , int i, int j, int width) {
		boolean allOne = !isZeroOrOutOfBound(m, i , j);
		
		// left 
		for (int k = 1; k < width && allOne; k++) {
			allOne = !isZeroOrOutOfBound(m, i, j-k);
		}
		
		// up
		for (int k = 1; k < width && allOne; k++) {
			allOne = !isZeroOrOutOfBound(m, i-k, j);
		}
		
		if (allOne) {
			return getSquareSize(m, i+1, j+1, width+1);
		}
		
		return (width-1)*(width-1);
	}
	
	public boolean isZeroOrOutOfBound(char[][] m , int i, int j) {
		return i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] == '0';
	}
	
	public static void main(String[] args) {
		char[][] matrix = new char[][] {
				{'1','1','0','0','0'},
				{'1','1','1','1','1'},
				{'0','0','1','1','1'},
				{'1','0','1','1','1'}
			};
		
		MaximalSquare m = new MaximalSquare();
		System.out.println(m.maximalSquare(matrix));
		
	}

}
