package com.zeetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;

import com.zeetcode.node.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)	 return null;

		LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		q.add(node);

		UndirectedGraphNode n;
		while (!q.isEmpty()) {
			n = q.poll();

			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (map.containsKey(neighbor)) {
					map.get(n).neighbors.add(map.get(neighbor));
				} else {
					UndirectedGraphNode newNeighbor = new UndirectedGraphNode(
							neighbor.label);
					map.put(neighbor, newNeighbor);
					map.get(n).neighbors.add(newNeighbor);
					q.add(neighbor);
				}
			}

		}

		return newNode;
	}
}
