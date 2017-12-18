package com.zeetcode.aalk.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	class WordNode {
        public String word;
        public int length;
        public WordNode(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }
    
	/**
	 * Given:
		beginWord = "hit"
		endWord = "cog"
		wordList = ["hot","dot","dog","lot","log"]
		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
		return its length 5.
	*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
        
        WordNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.word.equals(endWord)) {
                return node.length;
            }
            
            getWordNodes(queue, node, dict);
        }
        
        return 0;
    }
    
    /**
     * Find the next words from the word in node, add to the queue and remove from dict
     */
    private void getWordNodes(Queue<WordNode> queue, WordNode node, Set<String> dict) {
        
        String s;
        char c;
        char[] arr = node.word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            c = arr[i];
            for (int j = 0; j < 26; j++) {
                arr[i] = (char) ('a' + j);
                if (arr[i] == c) continue;
                
                s = new String(arr);
                if (dict.contains(s)) {
                    queue.add(new WordNode(s, node.length+1));
                    dict.remove(s);
                }
            }
            arr[i] = c;
        }
    }
}
