package com.zdesign.hangman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
	
	private SecretMessage secretMessage;
	private Hangman hangman;
	private Set<Character> availiableChar;
	
	public Game() {
		secretMessage = new SecretMessage(HangmanGameFactory.getRandomPhrase());
		hangman = new Hangman();
		
		availiableChar = new HashSet<Character>();
		char c = 'a';
		while (c <= 'z') {
			availiableChar.add(c);
			c += 1;
		}
	}
	
	private void printAvailiableChar() {
		char c = 'a';
		System.out.print("Your availiable characters");
		while (c <= 'z') {
			System.out.print(" ");
			if (availiableChar.contains(c))	System.out.print(c);
			c += 1;
		}
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public void play() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (!secretMessage.foundAllChars()) {
			
			System.out.println(hangman.getMan());
			System.out.println("Phrase: " + secretMessage.getGuessMessage());
			printAvailiableChar();
			
			System.out.print("Enter your guess (a char or phrase): ");
			String s = scanner.nextLine();
			s = s.trim();
			
			char guessChar;
			boolean result = false;
			
			if (s.length() == 0) {
				System.out.println("Please enter something!");
				System.out.println();
				continue;
			} else if (s.length() == 1) {
				guessChar = s.toLowerCase().charAt(0);
				result = secretMessage.guess(guessChar);
				availiableChar.remove(guessChar);
			} else if (s.length() > 1) {
				result = secretMessage.guess(s.toLowerCase());
			}
			
			if (!result) {
				System.out.println("Your guess \"" + s + "\" is wrong.");
				System.out.println();
				hangman.addManPart();
				
				// check whether the man hanged
				if (hangman.isComplete()) {
					System.out.println("Game over, you hang!");
					System.out.println(hangman.getMan());
					return;
				}
			} else {
				System.out.println(s + " is correct");
				System.out.println();
			}
			
			if (result && s.length() > 1) {
				secretMessage.end();
				break;
			}
		}
		
		System.out.println("You win!");
		System.out.println("The phrase is \"" + secretMessage.getGuessMessage() + "\"");
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
