package com.zdesign.hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HangmanGameServiceImpl implements HangmanGameService {

	private String secretMessage;
	private char[] guessMessage;;
	
	private HashMap<Character, List<Integer>> charToIndexes;
	private Set<Character> unusedChars;

	private Hangman hangman;
	
	public HangmanGameServiceImpl(String secretMsg) {
		secretMessage = secretMsg.toLowerCase().trim();
		guessMessage = new char[secretMessage.length()];
		
		charToIndexes = new HashMap<Character, List<Integer>>();
		char c;
		for (int i = 0; i < secretMessage.length(); i++) {
			c = secretMessage.charAt(i);
			if ('a' <= c && c <= 'z') {
				if (charToIndexes.containsKey(c)) {
					charToIndexes.get(c).add(i);
				} else {
					List<Integer> indexes = new ArrayList<Integer>();
					indexes.add(i);
					charToIndexes.put(c, indexes);
				}
				
				guessMessage[i] = '_';
			} else {
				guessMessage[i] = c;
			}
		}
		
		unusedChars = new HashSet<Character>();
		c = 'a';
		while (c <= 'z') {
			unusedChars.add(c);
			c += 1;
		}
		
		hangman = new Hangman();
	}
	
	
	
	@Override
	public boolean guess(char c) {
		if (!unusedChars.contains(c)) {
			return false;	// or throw exception?
		}
		
		if (charToIndexes.containsKey(c)) {
			for (Integer i : charToIndexes.get(c)) {
				guessMessage[i] = c;
			}
			charToIndexes.remove(c);
			unusedChars.remove(c);
			
			return true;
		}
		
		hangman.addManPart();
		unusedChars.remove(c);
		return false;
	}

	@Override
	public boolean guess(String message) {
		if (!secretMessage.equals(message)) {
			hangman.addManPart();
			return false;
		}
		
		charToIndexes.clear();
		guessMessage = secretMessage.toCharArray();
		return true;
	}
	
	private boolean guessMessageHelper(String message) {
		message = message.toLowerCase().trim();
		
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		char c;
		for (int i = 0; i < secretMessage.length(); i++) {
			c = secretMessage.charAt(i);
			if ('a' <= c && c <= 'z') {
				if (charCountMap.containsKey(c)) {
					charCountMap.put(c, charCountMap.get(c)+1);
				} else {
					charCountMap.put(c, 1);
				}
			}
		}
		
		for (int i = 0; i < message.length(); i++) {
			c = message.charAt(i);
			if ('a' <= c && c <= 'z') {
				if (charCountMap.containsKey(c)) {
					if (charCountMap.get(c) == 1) {
						charCountMap.remove(c);
					} else {
						charCountMap.put(c, charCountMap.get(c)-1);
					}
				} else {
					return false;
				}
			}
		}
		
		return charCountMap.isEmpty();
	}

	@Override
	public String getGuessMessage() {
		return new String(guessMessage);
	}

	@Override
	public Set<Character> getUnusedChars() {
		return unusedChars;
	}

	@Override
	public String getHangman() {
		return hangman.getMan();
	}

	@Override
	public boolean isWon() {
		return secretMessage.equals(new String(guessMessage));
	}
	
	public boolean isManHang() {
		return hangman.isComplete();
	}

	@Override
	public boolean isGameOver() {
		return isManHang() || isWon();
	}

}
