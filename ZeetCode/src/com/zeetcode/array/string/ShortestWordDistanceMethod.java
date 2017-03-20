package com.zeetcode.array.string;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
 *
 */
public class ShortestWordDistanceMethod {
	public int shortestDistance(String[] words, String word1, String word2) {
		int pos1 = -1;
		int pos2 = -1;
		
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				pos1 = i;
			} else if (words[i].equals(word2)) {
				pos2 = i;
			}
			
			if (pos1 != -1 && pos2 != -1) {
				minDistance = Math.min(minDistance, Math.abs(pos2-pos1));
			}
			
			/*	For case when word1.equals(word2) is true 
			if (pos1 != -1 && pos2 != -1 && pos1 != pos2) {
                minDistance = Math.min(minDistance, Math.abs(pos2 - pos1));
            }
			if (word1.equals(word2)) {
            	pos2 = pos1;
            }
            */
            
		}
		
		return minDistance;
	}
	
	public static void main(String[] args) {
		ShortestWordDistanceMethod s = new ShortestWordDistanceMethod();
		String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes", "happy", "makes"};
		
		System.out.println(s.shortestDistance(words, "makes", "coding"));
		//System.out.println(s.shortestDistance(words, "makes", "makes"));
	}
}
