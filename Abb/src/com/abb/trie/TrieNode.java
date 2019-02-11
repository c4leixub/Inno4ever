package com.abb.trie;

public class TrieNode {
	public TrieNode[] nodes;
    public boolean isEnd;   // determine this node is end of a word
    
    // Initialize your data structure here.
    public TrieNode() {
        nodes = new TrieNode[26];
        isEnd = false;
    }

}
