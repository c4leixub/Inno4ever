package com.zeetcode.string.abbreviation;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {

	private Map<String, Integer> wordCount;
	private Map<String, Integer> abbrCount;

	public UniqueWordAbbreviation(String[] dictionary) {
		wordCount = new HashMap<String, Integer>();
		abbrCount = new HashMap<String, Integer>();

		for (String word : dictionary) {
			if (!wordCount.containsKey(word)) {
				wordCount.put(word, 1);
			} else {
				wordCount.put(word, abbrCount.get(word) + 1);
			}

			String abbr = getAbbr(word);
			if (!abbrCount.containsKey(abbr)) {
				abbrCount.put(abbr, 1);
			} else {
				abbrCount.put(abbr, abbrCount.get(abbr) + 1);
			}
		}
	}

	public boolean isUnique(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}

		String abbr = getAbbr(word);
		
		if (abbrCount.containsKey(abbr)) {
			// some words contains the same abbr
            
			if (wordCount.containsKey(word)) {
                // word is in the dictionary
				// if unique, wordCount equals abbrCount
				return wordCount.get(word) == abbrCount.get(abbr);
            } else {
            	// other string != word has the same abbr
                return false;
            }
        }
        
		// no word contains the same abbr
        return true;
	}

	private String getAbbr(String word) {
		if (word == null || word.length() < 3) {
			return word;
		}

		StringBuffer sb = new StringBuffer();
		sb.append(word.charAt(0));
		sb.append(word.length() - 2);
		sb.append(word.charAt(word.length() - 1));

		return sb.toString();

	}

	public static void main(String[] args) {
		String[] dictionary = new String[] { "deer", "door", "cake", "card" };
		UniqueWordAbbreviation u = new UniqueWordAbbreviation(dictionary);

		System.out.println(u.isUnique("dear"));
		System.out.println(u.isUnique("cake"));

	}
}
