package com.zeetcode.matrix.search;

public class SearchMatrix {
	/**
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int s = 0, e = matrix.length - 1;
		int i = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (matrix[mid][0] <= target
					&& target <= matrix[mid][matrix[mid].length - 1]) {
				i = mid;
				break;
			} else if (target < matrix[mid][0]) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		if (i == -1)
			return false;

		s = 0;
		e = matrix[i].length - 1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (matrix[i][mid] == target) {
				return true;
			} else if (matrix[i][mid] < target) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		return false;
	}

	/**
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom.
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int i = 0, j = matrix[0].length - 1;
		while (0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length) {
			if (matrix[i][j] == target) {
				return true;
			} else if (target < matrix[i][j]) {
				j--;
			} else {
				i++;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] m = new int[][] {
				{ 1, 4, 7, 11, 15 }, 
				{ 2, 5, 8, 12, 19 },
				{ 3, 6, 9, 16, 22 }, 
				{ 10, 13, 14, 17, 24},
				{ 18, 21, 23, 26, 30 } 
		};
		
		SearchMatrix s = new SearchMatrix();
		System.out.println(s.searchMatrix2(m, 20));
	}
}
