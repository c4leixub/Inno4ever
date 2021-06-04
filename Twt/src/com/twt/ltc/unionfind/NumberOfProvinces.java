package com.twt.ltc.unionfind;

public class NumberOfProvinces {

	public int findCircleNum(int[][] isConnected) {

		int res = 0;
		boolean[] visited = new boolean[isConnected.length];
		for (int city = 0; city < isConnected.length; city++) {
			if (!visited[city]) {
				visited[city] = true;
				dfs(isConnected, city, visited);
				res++;
			}
		}
		return res;
	}
	
	private void dfs(int[][] isConnected, int city, boolean[] visited) {
		for (int next = 0; next < visited.length; next++) {
			if (next != city && !visited[next] && isConnected[city][next] == 1) {
				visited[next] = true;
				dfs(isConnected, next, visited);
			}
		}
	}
}
