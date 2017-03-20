package com.zeetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquare {

	public boolean validWordSquare(List<String> words) {
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= words.size() || i >= words.get(j).length()
						|| words.get(i).charAt(j) != words.get(j).charAt(i)) {
					return false;
				}
			}
		}

		return true;
	}
	
	// find all word squares
	class TrieNode {
		List<String> startWith;
		TrieNode[] children;

		TrieNode() {
			startWith = new ArrayList<>();
			children = new TrieNode[26];
		}
	}

	class Trie {
		TrieNode root;

		public Trie(String[] words) {
			root = new TrieNode();
			for (String w : words) {
				TrieNode cur = root;
				for (char ch : w.toCharArray()) {
					int idx = ch - 'a';
					if (cur.children[idx] == null) {
						cur.children[idx] = new TrieNode();
					}
					
					cur.children[idx].startWith.add(w);
					cur = cur.children[idx];
				}
			}
		}

		List<String> findByPrefix(String prefix) {
			List<String> ans = new ArrayList<>();
			TrieNode cur = root;
			for (char ch : prefix.toCharArray()) {
				int idx = ch - 'a';
				if (cur.children[idx] == null)
					return ans;

				cur = cur.children[idx];
			}
			ans.addAll(cur.startWith);
			return ans;
		}
	}
	
	public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        int len = words[0].length();
        List<String> list = new ArrayList<String>();
        Trie trie = new Trie(words);
        for (String w : words) {
            list.add(w);
            wordSquares(1, len, trie, result, list);
            list.remove(list.size()-1);
        }
        
        return result;
    }
    
    // dfs
    public void wordSquares(int i, int len, Trie trie, List<List<String>> result, List<String> list) {
        if (i == len) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        
        StringBuilder prefix = new StringBuilder();
        for (String s : list) {
            prefix.append(s.charAt(i));
        }
        
        List<String> startWith = trie.findByPrefix(prefix.toString());
        for (String w : startWith) {
            list.add(w);
            wordSquares(i+1, len, trie, result, list);
            list.remove(list.size()-1);
        }
    }
}
