package com.zdesign.hangman;

public class Hangman {
	
	private int state;
	private static final String[] DISPLAYS = new String[] {
		HangmanConstant.HANG,
		HangmanConstant.HEAD,
		HangmanConstant.BODY,
		HangmanConstant.LEFT_HAND,
		HangmanConstant.RIGHT_HAND,
		HangmanConstant.LEFT_LEG,
		HangmanConstant.RIGHT_LEG,
	};
	
	public Hangman() {
		state = 0;
	}

	public void addManPart() {
		if (isComplete()) return;
		state++;
	}
	
	public boolean isComplete() {
		return state == 6;
	}
	
	public String getMan() {
		return DISPLAYS[state];
	}
	
}
