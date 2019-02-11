package com.lkin.word.ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public class WordNode {
		public String word;
		public int len;

		public WordNode(String w, int l) {
			word = w;
			len = l;
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> dict = new HashSet<String>();
		for (String word : wordList) {
			dict.add(word);
		}
		
		if (!dict.contains(endWord)) return 0;

		Queue<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));

		WordNode node;
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (endWord.equals(node.word)) {
				return node.len;
			}

			findNextNode(queue, dict, node);
		}

		return 0;
	}

	private void findNextNode(Queue<WordNode> queue, Set<String> dict, WordNode cur) {
		char[] chars = cur.word.toCharArray();
		char t;
		String w;
		for (int i = 0; i < chars.length; i++) {
			t = chars[i];
			for (int j = 0; j < 26; j++) {
				chars[i] = (char) ('a' + j);
				w = new String(chars);
				if (dict.contains(w)) {
					queue.add(new WordNode(w, cur.len + 1));
					dict.remove(w);
				}
			}
			chars[i] = t;
		}

	}
}
