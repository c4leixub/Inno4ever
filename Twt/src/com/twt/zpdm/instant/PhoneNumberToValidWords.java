package com.twt.zpdm.instant;

import java.util.*;

import com.twt.ltc.trie.Trie;
import com.twt.ltc.trie.TrieNode;

public class PhoneNumberToValidWords {

	final String[] numberToLetters = new String[] { 
		"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"
	};
	
	public List<String> getValidWordsFromPhoneNumber(List<String> validWords, String phoneNumber) {
		
		List<String> result = new ArrayList<>();
		
		/*
		for (String word : validWords) trie.insert(word);
		TrieNode node = trie.root;
		dfs(node, phoneNumber, 0, new StringBuilder(), result);
		*/
		
		dfs(new HashSet<>(validWords), phoneNumber, 0, new StringBuilder(), result);
		
		return result;
	}
	
	private void dfs(TrieNode node, String phoneNumber, int index, StringBuilder sb, List<String> result) {
		if (index == phoneNumber.length()) {
			String word = sb.toString();
			if (node.isEnd) {
				result.add(word);
			}
			return;
		}
		
		String letters = numberToLetters[phoneNumber.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			TrieNode p = node.children[letters.charAt(i)-'a'];
			if (p != null) {
				sb.append(letters.charAt(i));
				dfs(p, phoneNumber, index + 1, sb, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	private void dfs(Set<String> words, String phoneNumber, int index, StringBuilder sb, List<String> result) {
		if (index == phoneNumber.length()) {
			String word = sb.toString();
			if (words.contains(word)) {
				result.add(word);
			}
			return;
		}
		
		String letters = numberToLetters[phoneNumber.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			sb.append(letters.charAt(i));
			dfs(words, phoneNumber, index + 1, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		
		PhoneNumberToValidWords p = new PhoneNumberToValidWords();
		
		List<String> validWords = Arrays.asList("bats", "cats");
		String phoneNumber = "2287";
		
		System.out.println(p.getValidWordsFromPhoneNumber(validWords, phoneNumber));
	}
} 
