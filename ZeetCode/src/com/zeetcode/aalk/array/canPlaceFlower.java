package com.zeetcode.aalk.array;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 */
public class canPlaceFlower {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (n == 0)
			return true;

		if (flowerbed.length == 0) {
			return false;
		}

		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				if ((i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
					flowerbed[i] = 1;
					count++;
				}
			}

			if (count == n) {
				return true;
			}
		}

		return false;
	}
}
