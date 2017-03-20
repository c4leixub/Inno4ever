package com.zeetcode.trie;

//Add and Search Word - Data structure design
public class WordDictionary {

	public class TrieNode {
		public TrieNode[] nodes;
		public boolean isEnd; // determine this node is end of a word

		// Initialize your data structure here.
		public TrieNode() {
			nodes = new TrieNode[26];
			isEnd = false;
		}
	}

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
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

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return search(word, root, 0);
	}

	// dfs
	public boolean search(String word, TrieNode p, int i) {
		if (Character.isLetter(word.charAt(i))) {
			int index = word.charAt(i) - 'a';
			if (p.nodes[index] == null) {
				return false;
			}

			if (i == word.length() - 1) {
				return p.nodes[index].isEnd;
			}

			return search(word, p.nodes[index], i + 1);
		}

		for (TrieNode node : p.nodes) {
			if (i == word.length() - 1) {
				if (node != null && node.isEnd) {
					return true;
				}
			} else {
				if (node != null && search(word, node, i + 1)) {
					return true;
				}
			}
		}

		return false;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
