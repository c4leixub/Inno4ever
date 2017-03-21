package com.zdesign.hangman;

import java.util.Set;

public interface HangmanGameService {
	
	public boolean guess(char c);
	
	public boolean guess(String message);
	
	public String getGuessMessage();
	
	public Set<Character> getUnusedChars();
	
	public String getHangman();
	
	public boolean isWon();
	
	public boolean isManHang();
	
	public boolean isGameOver();
	
}
