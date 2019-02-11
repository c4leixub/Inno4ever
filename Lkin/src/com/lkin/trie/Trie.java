package com.lkin.trie;

public class Trie {
	protected TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = findNode(word);
        if (p == null) {
            return false;
        }
        
        return p.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
    
    // Returns the last TrieNode if there is any word in the trie
    // that starts with the given prefix, otherwise null
    private TrieNode findNode(String prefix) {
        TrieNode p = root;
        int index;
        for (int i = 0; i < prefix.length(); i++) {
            index = prefix.charAt(i) - 'a';
            if (p.nodes[index] == null) {
                return null;
            }
            p = p.nodes[index];
        }
        
        return p;
	}
}
