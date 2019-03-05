package com.abb.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoggleGame {
	class TrieNode {
		public TrieNode[] nodes;
		public boolean isEnd; // determine this node is end of a word

		// Initialize your data structure here.
		public TrieNode() {
			nodes = new TrieNode[26];
			isEnd = false;
		}
	}

	public void insert(String word) {
		TrieNode p = root;
		int index;
		for (int i = 0; i < word.length(); i++) {
			index = word.charAt(i) - 'a';
			if (p.nodes[index] == null) {
				p.nodes[index] = new TrieNode();
			}
			p = p.nodes[index];
		}
		p.isEnd = true;
	}

	private TrieNode root = new TrieNode();

	public List<String> findMostStr(char[][] board, String[] words) {
		for (String word : words) {
			insert(word);
		}

		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		Set<String> max = new HashSet<String>();

		Set<String> result;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result = new HashSet<String>();
				dfs(board, visited, i, j, result, new StringBuilder(), root);
				if (result.size() > max.size()) {
					max = result;
				}
			}
		}

		return new ArrayList<String>(max);
	}

	public void dfs(char[][] board, boolean[][] visited, int i, int j, Set<String> result, StringBuilder sb,
			TrieNode node) {
		int m = board.length, n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
			return;
		}

		int index = board[i][j] - 'a';
		if (node.nodes[index] == null) {
			return;
		}

		visited[i][j] = true;
		sb.append(board[i][j]);
		if (node.nodes[index].isEnd) {
			//if (!result.contains(sb.toString())) {
				result.add(sb.toString());

				dfs(board, visited, i - 1, j, result, new StringBuilder(), root);
				dfs(board, visited, i + 1, j, result, new StringBuilder(), root);
				dfs(board, visited, i, j - 1, result, new StringBuilder(), root);
				dfs(board, visited, i, j + 1, result, new StringBuilder(), root);
			//}
		} else {

			dfs(board, visited, i - 1, j, result, sb, node.nodes[index]);
			dfs(board, visited, i + 1, j, result, sb, node.nodes[index]);
			dfs(board, visited, i, j - 1, result, sb, node.nodes[index]);
			dfs(board, visited, i, j + 1, result, sb, node.nodes[index]);
		}
		visited[i][j] = false;
		sb.deleteCharAt(sb.length() - 1);
	}

}
