package com.lkin.matrix.dfs;

public class FriendCircle {
	public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                traverse(M, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void traverse(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M[i].length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                traverse(M, visited, j);
            }
        }
    }
}
