package com.abb.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchTrie {
	class TrieNode {
        public TrieNode[] nodes;
        public boolean isEnd;   // determine this node is end of a word
        public boolean found;	// handle duplicates when adding to the list
        
        // Initialize your data structure here.
        public TrieNode() {
            nodes = new TrieNode[26];
            isEnd = false;
            found = false;
        }
    }
	
	class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
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
    }
	
	public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word); 
        }

		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		List<String> result = new ArrayList<String>();
        
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, i, j, result, new StringBuilder(), trie.root);
			}
		}
		
		return new ArrayList<String>(result);
    }
	
	public void dfs(char[][] board, boolean[][] visited, int i, int j, 
						List<String> result, StringBuilder sb, TrieNode node) {
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
		if (node.nodes[index].isEnd && !node.nodes[index].found) {
			result.add(sb.toString());
			node.nodes[index].found = true;
		}
		
		dfs(board, visited, i-1, j, result, sb, node.nodes[index]);
		dfs(board, visited, i+1, j, result, sb, node.nodes[index]);
		dfs(board, visited, i, j-1, result, sb, node.nodes[index]);
		dfs(board, visited, i, j+1, result, sb, node.nodes[index]);
		
		visited[i][j] = false;
		sb.deleteCharAt(sb.length()-1);
	}
	
}
