package com.zeetcode.word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public class WordNode {
		public String word;
		public int length;

		public WordNode(String word, int length) {
			this.word = word;
			this.length = length;
		}
	}

	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		Set<String> wordDict = new HashSet<String>();
		for (String w : wordList) {
			wordDict.add(w);
		}

		if (!wordDict.contains(endWord)) {
			return 0;
		}

		Queue<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));

		WordNode node;
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (endWord.equals(node.word)) {
				return node.length;
			}
			List<String> words = getWords(node.word, wordDict);
			for (String w : words) {
				queue.add(new WordNode(w, node.length + 1));
				wordDict.remove(w);
			}
		}

		return 0;
	}

	public List<String> getWords(String word, Set<String> wordDict) {
		List<String> result = new ArrayList<String>();
		char[] str = word.toCharArray();
		char c;
		String s;
		for (int i = 0; i < str.length; i++) {
			c = str[i];
			for (int j = 0; j < 26; j++) {
				str[i] = ((char) ('a' + j));
				s = new String(str);
				if (wordDict.contains(s)) {
					result.add(s);
				}
			}
			str[i] = c;
		}

		return result;
	}
}
