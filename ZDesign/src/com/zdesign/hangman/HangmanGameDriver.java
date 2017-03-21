package com.zdesign.hangman;

import java.util.Scanner;
import java.util.Set;

public class HangmanGameDriver {
	
	private HangmanGameService hangmanGameService;
	
	public HangmanGameDriver() {
		hangmanGameService = HangmanGameFactory.createGame();
	}
	
	@SuppressWarnings({ "resource" })
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		while (!hangmanGameService.isGameOver()) {
			
			System.out.println(hangmanGameService.getHangman());
			System.out.println("Message: " + hangmanGameService.getGuessMessage().toUpperCase());
			printAvailiableChar(hangmanGameService.getUnusedChars());
			System.out.print("Enter a character or guess the message: ");
			
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
				result = hangmanGameService.guess(guessChar);
			} else {	// s.length() > 1
				result = hangmanGameService.guess(s.toLowerCase());
			}
			
			if (!result) {
				System.out.println("Your guess \"" + s + "\" is wrong.\n");
				
				// check game status
				if (!hangmanGameService.isWon() && hangmanGameService.isManHang()) {
					System.out.println("Game over, your man is hanged!");
					System.out.println(hangmanGameService.getHangman());
				}
			} else if (s.length() == 1) {
				System.out.println(s + " is correct");
				System.out.println();
			} else {	// s.length() > 1
				System.out.println("You win!");
				System.out.println("The message is \"" + hangmanGameService.getGuessMessage().toUpperCase() + "\"");
			}
		}
	}
	
	private void printAvailiableChar(Set<Character> charSet) {
		
		StringBuilder sb = new StringBuilder();
		char c = 'a';
		sb.append("Unused characters:");
		while (c <= 'z') {
			if (charSet.contains(c)) {
				sb.append(' ');
				sb.append(c);
			}
			c += 1;
		}
		System.out.println(sb.toString().toUpperCase());
	}
	
	public static void main(String[] args) {
		HangmanGameDriver driver = new HangmanGameDriver();
		driver.run();
	}
}
