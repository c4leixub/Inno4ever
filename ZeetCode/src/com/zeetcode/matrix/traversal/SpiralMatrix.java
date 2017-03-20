package com.zeetcode.matrix.traversal;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0) return result;
		
		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {
			// (Special case) if one row/column left,
			// no circle can be formed
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			// four loop below, circles edge of the matrix

			for (int i = 0; i < n - 1; i++) { // top - move right
				result.add(matrix[x][y]);
				y++;
			}

			for (int i = 0; i < m - 1; i++) { // right - move down
				result.add(matrix[x][y]);
				x++;
			}

			for (int i = 0; i < n - 1; i++) { // down - move left
				result.add(matrix[x][y]);
				y--;
			}

			for (int i = 0; i < m - 1; i++) { // left - move up
				result.add(matrix[x][y]);
				x--;
			}

			// move to the inner of the matrix
			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}

		return result;
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];

		int x = 0;
		int y = 0;

		int e = 1;
		int size = n * n;
		while (e <= size) {
			if (n == 1) {
				matrix[x][y] = e;
				break;
			}

			// four loop below, circles edge of the matrix
			for (int i = 0; i < n - 1; i++) { // top - move right
				matrix[x][y] = e;
				e++;
				y++;
			}

			for (int i = 0; i < n - 1; i++) { // right - move down
				matrix[x][y] = e;
				e++;
				x++;
			}

			for (int i = 0; i < n - 1; i++) { // down - move left
				matrix[x][y] = e;
				e++;
				y--;
			}

			for (int i = 0; i < n - 1; i++) { // left - move up
				matrix[x][y] = e;
				e++;
				x--;
			}

			x++;
			y++;
			n = n - 2;
		}

		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		SpiralMatrix s = new SpiralMatrix();
		System.out.println(s.spiralOrder(matrix) + "\n");

		int n = 3;
		int[][] m = s.generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
