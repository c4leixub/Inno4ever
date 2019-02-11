package com.abb.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairTrie {
	
	public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //HashMap<String, Integer> map = new HashMap<String, Integer>();
        Trie trie = new Trie();
        int emptyIndex = -1;
        for (int i = 0; i < words.length; i++) {
        	if (words[i].isEmpty()) {
        		emptyIndex = i;
        	} else {
        		trie.insert(words[i]);
        	}
        	
        }
        
        for (int i = 0; i < words.length; i++) {
        	String s = words[i];
        	
        	// if the word is a palindrome, get index of ""
        	if (!s.isEmpty() && isPalindrome(s) && emptyIndex != -1) {
        		addPair(i, emptyIndex, result);
        		addPair(emptyIndex, i, result);
        	}
        	
        	//if the reversed word exists and not itself
        	String reverse = new StringBuilder(s).reverse().toString();
        	if (trie.search(reverse)) {
        		addPair(i, map.get(reverse).intValue(), result);
        	}
        	
        	TrieNode node = trie.root;
        	for (int k = 1; k < s.length(); k++) { 
        		String left = s.substring(0, k);
        		String right = s.substring(k);
        		
        		//if left part is palindrome, find reversed right part
        		if (isPalindrome(left)) {
        			String rightReverse = new StringBuilder(right).reverse().toString();
        			if (map.containsKey(rightReverse)) {
        				addPair(map.get(rightReverse), i, result);
        			}
        		}
        		
                //if right part is a palindrome, find reversed left part
        		if (isPalindrome(right)) {
        			String leftReverse = new StringBuilder(left).reverse().toString();
        			if (map.containsKey(leftReverse)) {
        				addPair(i, map.get(leftReverse), result);
        			}
        		}
        	}
        }
        
        return result;
    }
    
	private void addPair(int i , int j, List<List<Integer>> result) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(i);
		list.add(j);
		result.add(list);
	}
	
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
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
