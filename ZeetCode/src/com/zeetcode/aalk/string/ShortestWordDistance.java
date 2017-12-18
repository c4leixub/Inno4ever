package com.zeetcode.aalk.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

	private Map<String, List<Integer>> wordToIndexes = new HashMap<String, List<Integer>>();

	public ShortestWordDistance(String[] words) {
		wordToIndexes = new HashMap<String, List<Integer>>();

		for (int k = 0; k < words.length; k++) {
			if (!wordToIndexes.containsKey(words[k])) {
				wordToIndexes.put(words[k], new ArrayList<Integer>());
			}
			wordToIndexes.get(words[k]).add(k);
		}
	}

	public int shortestDistance(String word) {
		if (!wordToIndexes.containsKey(word))
			return -1;

		List<Integer> indexes = wordToIndexes.get(word);
		if (indexes.size() == 1)
			return 0;

		int minDistance = Integer.MAX_VALUE;
		for (int i = 1; i < indexes.size(); i++) {
			minDistance = Math.min(minDistance, indexes.get(i) - indexes.get(i - 1));
		}

		return minDistance;
	}

	public int shortestDistance(String word1, String word2) {
		if (!wordToIndexes.containsKey(word1) || !wordToIndexes.containsKey(word2))
			return -1;

		if (word1.equals(word2))
			return shortestDistance(word1);

		List<Integer> indexes1 = wordToIndexes.get(word1);
		List<Integer> indexes2 = wordToIndexes.get(word2);

		int minDistance = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (i < indexes1.size() && j < indexes2.size()) {			
			minDistance = Math.min(minDistance, Math.abs(indexes1.get(i)-indexes2.get(j)));
            
            if (indexes1.get(i) < indexes2.get(j)) {
                i++;
            } else {
                j++;
            }
		}

		return minDistance;
	}
}
