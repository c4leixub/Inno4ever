package com.zdesign.hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecretMessage {
	
	private String message;
	private char[] guessMessage;
	
	private HashMap<Character, List<Integer>> charToIndexes
				= new HashMap<Character, List<Integer>>();
	
	public SecretMessage(String msg) {
		this.message = msg.toLowerCase().trim();
		this.guessMessage = new char[this.message.length()];
		
		char c;
		for (int i = 0; i < message.length(); i++) {
			c = message.charAt(i);
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
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getGuessMessage() {
		return new String(guessMessage); 
	}
	
	public boolean guess(char c) {
		if (charToIndexes.containsKey(c)) {
			for (Integer i : charToIndexes.get(c)) {
				guessMessage[i] = c;
			}
			charToIndexes.remove(c);
			return true;
		}
		
		return false;
	}
	
	public boolean guess(String s) {
		return message.equals(s);
	}
	
	public boolean foundAllChars() {
		return charToIndexes.isEmpty();
	}
	
	public void end() {
		charToIndexes.clear();
		this.guessMessage = this.message.toCharArray();
	}
	
}
