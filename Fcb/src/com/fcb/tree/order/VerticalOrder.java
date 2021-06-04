package com.fcb.tree.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.fcb.node.TreeNode;

import javafx.util.Pair;

public class VerticalOrder {
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		// key = column, value = <row, node_value>
		Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<Integer, List<Pair<Integer, Integer>>>();

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> columns = new LinkedList<Integer>();

		nodes.add(root);
		columns.add(0);

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		TreeNode node;
		Integer col;
		List<Pair<Integer, Integer>> list;
		int row = 0, size;
		while (!nodes.isEmpty()) {
			size = nodes.size();

			while (size > 0) {
				node = nodes.poll();
				col = columns.poll();

				min = Math.min(min, col);
				max = Math.max(max, col);

				if (node.left != null) {
					nodes.add(node.left);
					columns.add(col - 1);
				}

				if (node.right != null) {
					nodes.add(node.right);
					columns.add(col + 1);
				}

				list = map.get(col);
				if (list == null) {
					list = new ArrayList<Pair<Integer, Integer>>();
					map.put(col, list);
				}
				list.add(new Pair<>(row, node.val));

				size--;
			}

			row++;
		}

		/**
		 * We divide into K sublists equally. Each list would contain N/K elements.
		 * Similarly, it would take O(N/K log N/K) to sort each sublist. In total, to
		 * sort all the kk sublists, it would take O(K * N/K log N/K) = O(N log N/K)
		 */
		List<Integer> temp;
		for (int i = min; i <= max; i++) {
			temp = new ArrayList<>();

			list = map.get(i);
			Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
					return o1.getKey() == o2.getKey() ? o1.getValue() - o2.getValue() : o1.getKey() - o2.getKey();
				}
			});

			for (int j = 0; j < list.size(); j++) {
				temp.add(list.get(j).getValue());
			}
			result.add(temp);
		}

		return result;
	}
}
