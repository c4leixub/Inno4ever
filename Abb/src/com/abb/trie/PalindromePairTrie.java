package com.abb.trie;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairTrie {

	class TrieNode {
		TrieNode[] nodes;
		List<Integer> pos;
		int index;

		public TrieNode() {
			nodes = new TrieNode[26];
			pos = new ArrayList<Integer>();
			index = -1;
		}
	}

	private void insert(TrieNode root, String word, int i) {
		TrieNode p = root;
		int index;
		for (int j = word.length() - 1; j >= 0; j--) {
			index = word.charAt(j) - 'a';
			if (p.nodes[index] == null) {
				p.nodes[index] = new TrieNode();
			}

			if (this.isPalindrome(word, 0, j)) {
				p.pos.add(i);
			}

			p = p.nodes[index];
		}

		p.index = i;
		p.pos.add(i);
	}

	private void search(TrieNode root, String word, int i, List<List<Integer>> result) {
		TrieNode p = root;
		int index;
		for (int j = 0; j < word.length(); j++) {
			index = word.charAt(j) - 'a';

			if (p.index >= 0 && p.index != i && this.isPalindrome(word, j, word.length() - 1)) {
				addPair(i, p.index, result);
			}

			if (p.nodes[index] == null) {
				return;
			}
			p = p.nodes[index];
		}

		for (Integer j : p.pos) {
			if (i == j) {
				continue;
			} else {
				addPair(i, j, result);
			}
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int emptyIndex = -1;

		// construct trie
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			this.insert(root, words[i], i);
		}

		// search for pairs
		for (int i = 0; i < words.length; i++) {
			this.search(root, words[i], i, result);
		}

		return result;
	}

	private void addPair(int i, int j, List<List<Integer>> result) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(i);
		list.add(j);
		result.add(list);
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}
}
