package com.lkin.string.other;

public class ShortestWordDistanceOneThree {
	public int shortestDistance(String[] words, String word1, String word2) {
        
		boolean isSameWord = word1.equals(word2);
		
		int min = Integer.MAX_VALUE, index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
            	
            	
            	if (isSameWord) {	// ShortestWordDistanceIII
                    if (index1 != -1) {
                        min = Math.min(min, i-index1);
                    }
                    index1 = i;
                    continue;
                }
            	
            	
            	index1 = i;
                if (index2 != -1) {
                    min = Math.min(min, Math.abs(index1-index2));
                }
            }
            
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    min = Math.min(min, Math.abs(index1-index2));
                }
            }
        }
        
        return min;
    }
}
