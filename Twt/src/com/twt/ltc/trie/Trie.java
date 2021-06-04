package com.twt.ltc.trie;

public class Trie {
	public TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode(' ');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		int index;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			index = word.charAt(i) - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode(c);
			}
			node = node.children[index];
		}
		node.isEnd = true;
		node.word = word;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd;
	}

	private TrieNode searchPrefix(String prefix) {
		TrieNode node = root;
		int index;
		for (int i = 0; i < prefix.length(); i++) {
			index = prefix.charAt(i) - 'a';
			if (node.children[index] == null) {
				return null;
			}
			node = node.children[index];
		}

		return node;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}
}
