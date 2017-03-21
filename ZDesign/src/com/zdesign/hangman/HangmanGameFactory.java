package com.zdesign.hangman;

import java.util.Random;

public class HangmanGameFactory {

	public static String[] PHRASES = new String[] {
		"I love you ",
		"Today is Friday."
	};
	
	private static Random RANDOM = new Random();
	
	public static String getRandomPhrase() {
		return PHRASES[RANDOM.nextInt(PHRASES.length)];
	}
	
	public static HangmanGameService createGame() {
		return new HangmanGameServiceImpl(getRandomPhrase());
	}
}
