package com.twt.ltc.trie;

public class TrieNode {
	
	public char value;
	public TrieNode[] children;
	public boolean isEnd;
	public String word;

	public TrieNode(char value) {
		this.value = value;
		children = new TrieNode[26];
		isEnd = false;
		word = null;
	}
}
