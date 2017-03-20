package com.zeetcode.alinkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * In "the 100 game," two players take turns adding, to a running total, any
 * integer from 1..10. The player who first causes the running total to reach or
 * exceed 100 wins.
 * 
 * What if we change the game so that players cannot re-use integers?
 * 
 * For example, if two players might take turns drawing from a common pool of
 * numbers of 1..15 without replacement until they reach a total >= 100. This
 * problem is to write a program that determines which player would win with
 * ideal play.
 * 
 * Write a procedure,
 * "Boolean canIWin(int maxChoosableInteger, int desiredTotal)", which returns
 * true if the first player to move can force a win with optimal play.
 */
public class AddToHundredGame {

	public Boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (maxChoosableInteger <= 0 || desiredTotal <= 0) {
			return false;
		}

		List<Integer> pool = new ArrayList<>();
		for (int i = 1; i <= maxChoosableInteger; i++) {
			pool.add(i);
		}

		return canIWinHelper(pool, desiredTotal);
	}

	private boolean canIWinHelper(List<Integer> pool, int desiredTotal) {
		if (pool.get(pool.size() - 1) >= desiredTotal) {
			return true;
		}

		for (int i = 0; i < pool.size(); i++) {
			int removed = pool.remove(i);

			boolean win = !canIWinHelper(pool, desiredTotal - removed);

			pool.add(i, removed);

			if (win) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int max = 10;
		int total = 11;

		AddToHundredGame solution = new AddToHundredGame();
		boolean ans = solution.canIWin(max, total);

		System.out.println(ans);
	}
}
