package com.zeetcode.array.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.zeetcode.array.string.WordLadder2.WordNode;

public class WordLadder {
	
	/**
	 * Given:
		beginWord = "hit"
		endWord = "cog"
		wordList = ["hot","dot","dog","lot","log"]
		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
		return its length 5.
	*/
	
	class WordNode{
	    String word;
	    int numSteps;
	    
	    WordNode pre;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	    
	    public WordNode(String word, int numSteps, WordNode pre) {
			this.word = word;
			this.numSteps = numSteps;
			this.pre = pre;
		}
	}
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		if (wordDict == null) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }
		
		Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
        
        Set<String> dict = new HashSet<String>(wordDict);
        dict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            getNextWords(word, queue, top.numSteps, dict);
        }
 
        return 0;
    }
	
	// replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private void getNextWords(String word, Queue<WordNode> queue, int numSteps, Set<String> dict) {
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                	queue.add(new WordNode(nextWord, numSteps+1));
                    dict.remove(nextWord);
                }
            }
        }
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	
    	LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1, null));
		
		return result;
    	
    }
}
