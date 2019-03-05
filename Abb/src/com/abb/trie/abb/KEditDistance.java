package com.abb.trie.abb;

import java.util.ArrayList;
import java.util.List;

import com.abb.trie.Trie;
import com.abb.trie.TrieNode;

public class KEditDistance {

	/**
	 * Find all words from a dictionary that are at least k edit distance away.
	 */
	public List<String> getKEditDistance(String[] words, String target, int k) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0 || target == null || target.length() == 0 || k < 0) {
			return res;
		}

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		TrieNode root = trie.root;
		// The edit distance from curr to target
		int[] prev = new int[target.length() + 1];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = i;
		}

		dfs("", target, k, root, prev, new ArrayList<>());
		return res;
	}

	private void dfs(String curr, String target, int k, TrieNode root, int[] prevDist, List<String> result) {
		if (root.isEnd) {
			if (prevDist[target.length()] <= k) {
				result.add(curr);
			} else {
				return;
			}
		}
		
		for (int i = 0; i < 26; i++) {
			if (root.nodes[i] == null) {
				continue; 
			}
			
			int[] currDist = new int[target.length() + 1];
			currDist[0] = curr.length() + 1;
			for (int j = 1; j < prevDist.length; j++) {
				if (target.charAt(j - 1) == (char) (i + 'a')) { 
					currDist[j] = prevDist[j - 1];
				} else {
					currDist[j] = Math.min(Math.min(prevDist[j - 1], prevDist[j]), currDist[j - 1]) + 1; 
				}
			}
			
			dfs(curr+(char)(i+'a'), target, k, root.nodes[i], currDist, result);
		}
	}

}