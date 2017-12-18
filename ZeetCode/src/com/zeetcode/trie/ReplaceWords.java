package com.zeetcode.trie;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReplaceWords {
	public class TrieNode {
        // Initialize your data structure here.

        public Map<Character, TrieNode> children;
        public boolean isEnd;
        public TrieNode() {
            children = new TreeMap<Character, TrieNode>();
            isEnd = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            int i = 0;
            char c;
            while (i < word.length()) {
                c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                i++;
            }
            node.isEnd = true;
        }
        
        public String searchRoot(String word) {
            StringBuilder sb = new StringBuilder();
            TrieNode node = root;
            int i = 0;
            char c;
            while (i < word.length()) {
                c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    break;
                }
                node = node.children.get(c);
                sb.append(c);
                i++;
            }

            if (node != null && node.isEnd) {
                return sb.toString();
            }
            
            return word;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        
        Trie trie = new Trie();
        
        for (String word : dict) {
            trie.insert(word);
        }
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(trie.searchRoot(words[i]));
            sb.append(" ");
        }
        
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        
        return sb.toString();
    }
}
