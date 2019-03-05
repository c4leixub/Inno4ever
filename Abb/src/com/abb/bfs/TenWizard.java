package com.abb.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are 10 wizards, 0-9, you are given a list that each entry is a list of
 * wizards known by wizard. Define the cost between wizards and wizard as square
 * of different of i and j. To find the min cost between 0 and 9.
 * wizard[0] list: 1, 4, 5, wizard[4] list: 9 wizard 0 to 9 min distance is
 * (0-4)^2+(4-9)^2=41 (wizard[0] ->wizard[4]->wizard[9])
 * 
 * Wizard level is not the same, find the shortest path in direct graph
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=277494
 */
public class TenWizard {
	class Wizard implements Comparable<Wizard> {
		int id;
		int dist;
		
		public Wizard(int id) {
			this.id = id;
			dist = Integer.MAX_VALUE;
		}

		@Override
		public int compareTo(Wizard o) {
			return this.dist - o.dist;
		}
	}
	
	// O(V) where v the vertex
	public List<Integer> getShortestPath(List<List<Integer>> wizards, int n, int source, int target) {
		if (wizards == null || wizards.size() == 0)
			return null;

		int[] parent = new int[n];
		Map<Integer, Wizard> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			map.put(i, new Wizard(i));
		}

		map.get(source).dist = 0;
		Queue<Wizard> pq = new PriorityQueue<>(n);
		pq.offer(map.get(source));

		while (!pq.isEmpty()) {
			Wizard curr = pq.poll();
			
			List<Integer> neighbors = wizards.get(curr.id);			
			for (int neighbor : neighbors) {
				Wizard next = map.get(neighbor);
				int weight = (int) Math.pow(next.id - curr.id, 2);
				if (curr.dist + weight < next.dist) {
					parent[next.id] = curr.id;
					pq.remove(next);
					next.dist = curr.dist + weight;
					pq.offer(next);
				}
			}
		}

		int minCost = 0;
		List<Integer> path = new ArrayList<>();
		int t = target;
		while (t != source) {
			path.add(t);
			minCost += (int) Math.pow(t - parent[t], 2);
			t = parent[t];
		}
		path.add(source);
		
		System.out.println(minCost);
		
		Collections.reverse(path);
		return path;
	}
	
	public static void main(String[] args) {
		TenWizard t = new TenWizard();
		List<List<Integer>> wizards = new ArrayList<List<Integer>>();
		
		List<Integer> w0 = new ArrayList<Integer>();
		w0.add(1);
		w0.add(4);
		w0.add(5);
		
		List<Integer> w4 = new ArrayList<Integer>();
		w4.add(9);
		
		wizards.add(w0);
		wizards.add(new ArrayList<>());
		wizards.add(new ArrayList<>());
		wizards.add(new ArrayList<>());
		wizards.add(w4);
		wizards.add(new ArrayList<>());
		wizards.add(new ArrayList<>());
		wizards.add(new ArrayList<>());
        wizards.add(new ArrayList<>());
        wizards.add(new ArrayList<>());

		System.out.println(t.getShortestPath(wizards, 10, 0, 9));
		
		int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
        wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }
        List<Integer> res = t.getShortestPath(wizards, 10, 0, 9);
        System.out.println(res);
        
        
        
		
	}
}
