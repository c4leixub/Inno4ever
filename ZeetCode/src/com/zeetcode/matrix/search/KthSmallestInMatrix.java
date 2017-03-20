package com.zeetcode.matrix.search;

/** Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.	*/
public class KthSmallestInMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;

		int lower = matrix[0][0];
		int upper = matrix[m - 1][m - 1];

		while (lower < upper) {
			int mid = lower + ((upper - lower) >> 1);
			int count = count(matrix, mid);
			if (count < k) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}

		return upper;
	}

	// count elements smaller than target
	private int count(int[][] matrix, int target) {
		int m = matrix.length;
        int i = 0;
        int j = m -1 ;
        int count = 0;
        
        while (i < m && j >= 0) {
            if (matrix[i][j] <= target) {
                // on row i we have (j+1) element <= target, add to count
                count += (j+1);
                i++;    // check the next row
            } else {
                j--;
            }
        }
        
        return count;
	}
}
