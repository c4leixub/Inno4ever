package com.lkin.string.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceTwo {

	private Map<String, List<Integer>> wordToIndexes;
    
    public ShortestWordDistanceTwo(String[] words) {
        wordToIndexes = new HashMap<String, List<Integer>>();
        
        for (int i = 0; i < words.length; i++) {
            if (!wordToIndexes.containsKey(words[i])) {
                wordToIndexes.put(words[i], new ArrayList<Integer>());
            }
            
            wordToIndexes.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        if (word1 == null || word2 == null
                || !wordToIndexes.containsKey(word1)
                || !wordToIndexes.containsKey(word2)) {
            return -1;
        }
        
        List<Integer> list1 = wordToIndexes.get(word1);
        List<Integer> list2 = wordToIndexes.get(word2);
        
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return min;
    }
}
