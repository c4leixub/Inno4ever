package com.twt.ltc.trie;

import java.util.*;

public class WordSearchTrie {

	int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<String> findWords(char[][] board, String[] words) {

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (trie.root.children[board[i][j] - 'a'] != null) {
					dfs(board, i, j, trie.root, result);
				}
			}
		}

		return result;
	}

	private void dfs(char[][] board, int i, int j, TrieNode parent, List<String> result) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'
				|| parent.children[board[i][j] - 'a'] == null) {
			return;
		}

		char c = board[i][j];
		TrieNode node = parent.children[board[i][j] - 'a'];

		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}

		board[i][j] = '#';
		for (int[] d : direction) {
			dfs(board, i + d[0], j + d[1], node, result);
		}
		board[i][j] = c;
	}
}
