package com.lkin.word.ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

	class WordNode {
		String word;
		int numSteps;
		WordNode pre;

		public WordNode(String word, int numSteps, WordNode pre) {
			this.word = word;
			this.numSteps = numSteps;
			this.pre = pre;
		}
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();

		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1, null));

		HashSet<String> visited = new HashSet<String>();
		HashSet<String> unvisited = new HashSet<String>();
		
		unvisited.addAll(dict);
		unvisited.add(end);

		int minStep = 0;
		int preNumSteps = 0;

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;

			if (word.equals(end)) {
				if (minStep == 0) {
					minStep = top.numSteps;
				}

				if (top.numSteps == minStep && minStep != 0) {
					// nothing
					ArrayList<String> t = new ArrayList<String>();
					t.add(top.word);
					while (top.pre != null) {
						t.add(0, top.pre.word);
						top = top.pre;
					}
					result.add(t);
					continue;
				}

			}

			if (preNumSteps < currNumSteps) {
				unvisited.removeAll(visited);
			}
			preNumSteps = currNumSteps;

			getNextWords(top, queue, currNumSteps, unvisited, visited);
			
		}

		return result;
	}
	
	private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private void getNextWords(WordNode node, Queue<WordNode> queue, int numSteps,
    							Set<String> unvisited, Set<String> visited) {
        String word = node.word;
    	
    	for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (unvisited.contains(nextWord)) {
                	queue.add(new WordNode(nextWord, numSteps+1, node));
                	visited.add(nextWord);
                }
            }
        }
    }
}
