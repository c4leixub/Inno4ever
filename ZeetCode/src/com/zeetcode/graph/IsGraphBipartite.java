package com.zeetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	
	public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);   
    
        //This graph might be a disconnected graph. So check each unvisited node.
        for (int i = 0; i < n; i++) { 
            if (colors[i] == -1 && !validColor(graph, colors, 0, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }       
        colors[node] = color;       
        for (int next : graph[node]) {
            if (!validColor(graph, colors, 1 - color, next)) {
                return false;
            }
        }
        return true;
    }
    
    // a slower BFS solution
    public boolean isBipartiteBFS(int[][] graph) {
        int[] colors = new int[graph.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) continue;
            
            colors[i] = 1;
            queue.add(i);
            
            while (!queue.isEmpty()) {
			    Integer t = queue.poll();
                
                for (Integer e : graph[t]) {
                    if (colors[e] == 0) {
                        colors[e] = -1 * colors[t];
                        queue.add(e);
                    } else {
                        if (colors[e] == colors[t]) return false;
                    }
                }
            }
        }
        
        return true;
    }
}
