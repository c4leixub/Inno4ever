package com.zeetcode.matrix.traversal;

import java.util.ArrayList;
import java.util.List;

public class OceanWaterFlow {
	int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private void flow(boolean visited[][], int matrix[][], int i, int j, int m,
			int n) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + directions[k][0];
			int y = j + directions[k][1];
			if (x >= 0 && x < m && y >= 0 && y < n) {
				// 一个节点是只能留到不高于自己高度的节点，但是我们这里是反过来找能从nxny留到xy的节点，所以这里注意下
				if (visited[x][y] == false && matrix[x][y] >= matrix[i][j])
					flow(visited, matrix, x, y, m, n);
			}
		}
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<int[]>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return res;

		int m = matrix.length, n = matrix[0].length;
		boolean PV[][] = new boolean[m][n];
		boolean AV[][] = new boolean[m][n];

		// 这里从所有临海的地方到这回去判断某个节点是否能流到对应的地方
		for (int i = 0; i < m; i++) {
			flow(PV, matrix, i, 0, m, n);
			flow(AV, matrix, i, n - 1, m, n);
		}

		for (int i = 0; i < n; i++) {
			flow(PV, matrix, 0, i, m, n);
			flow(AV, matrix, m - 1, i, m, n);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (PV[i][j] && AV[i][j])
					res.add(new int[] { i, j });
			}
		}

		return res;

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 },
				{ 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };

		OceanWaterFlow o = new OceanWaterFlow();
		for (int[] ar : o.pacificAtlantic(matrix)) {
			System.out.print(" [" + ar[0] + ", " + ar[1] + "]");
		}
		System.out.println();

		// System.out.println(o.toOcean(2, 4, 3, matrix, new
		// boolean[matrix.length][matrix[0].length],0, 0));
	}
}
