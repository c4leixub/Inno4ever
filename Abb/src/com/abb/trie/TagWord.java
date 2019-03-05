package com.abb.trie;

import java.util.HashMap;
import java.util.Map;

public class TagWord {

	public class TrieNode {
		public Map<Character, TrieNode> nodes;
		public boolean isEnd; // determine this node is end of a word
		public String tag;
		char cs;

		// Initialize your data structure here.
		public TrieNode(char cs) {
			this.cs = cs;
			nodes = new HashMap<Character, TrieNode>();
			isEnd = false;
		}
	}

	private void insert(String word, String tag) {
		TrieNode p = root;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			if (!p.nodes.containsKey(c)) {
				p.nodes.put(c, new TrieNode(c));
			}
			p = p.nodes.get(c);
		}
		p.isEnd = true;
		p.tag = tag;
	}

	
	private TrieNode root;

	public TagWord(Map<String, String> dict) {
		root = new TrieNode(' ');
		for (String key : dict.keySet()) {
			insert(key, dict.get(key));
		}
	}

	public String tag(String s) {
		StringBuilder res = new StringBuilder();

		int i = 0;
		char c = 0;
		while (i < s.length()) {
			c = s.charAt(i);
			if (root.nodes.containsKey(c)) {
				TrieNode p = root;
		        while (i < s.length() && p.nodes.containsKey(c)) {
		        	res.append(c);
					i++;
					p = p.nodes.get(c);
					if (p.isEnd) {
						res.append('[');
						res.append(p.tag);
						res.append(']');
						break;
					}
					c = s.charAt(i);
		        }
			} else {
				res.append(c);
				i++;
			}
		}

		return res.toString();
	}

	public static void main(String[] args) {
		Map<String, String> dict = new HashMap<String, String>();
		dict.put("airbnb", "company");
		dict.put("bay area", "place");
		
		TagWord t = new TagWord(dict);
		String s = "I love airbnb, Airbnb is awesome. Bay area is a great place! I love to live at the bay area.";
		
		System.out.println(t.tag(s.toLowerCase()));
	}
}
