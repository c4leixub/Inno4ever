package com.twt.ltc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		// old to new Node map
		Map<Node, Node> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<Node>();

		Node newNode = new Node(node.val);
		visited.put(node, newNode);
		q.add(node);

		Node n, newNeighbor;
		while (!q.isEmpty()) {
			n = q.poll();

			for (Node neighbor : n.neighbors) {

				newNeighbor = visited.get(neighbor);
				if (newNeighbor == null) {
					newNeighbor = new Node(neighbor.val);
					visited.put(neighbor, newNeighbor);
					
					// we never visit this neighbor, add to queue
					// if the neighbor is visited then a mapping should exist
					q.add(neighbor);
				}
				visited.get(n).neighbors.add(newNeighbor);
			}
		}

		return newNode;
	}
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
}
