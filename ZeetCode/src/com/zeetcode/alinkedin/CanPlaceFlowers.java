package com.zeetcode.alinkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both
 * would die. Given a flowerbed (represented as an array containing booleans), return if a given
 * number of new flowers can be planted in it without violating the no-adjacent-flowers rule
 Sample inputs

 Input: 1,0,0,0,0,0,1,0,0
 3 => true
 4 => false

 Input: 1,0,0,1,0,0,1,0,0
 1 => true
 2 => false

 input: 0
 1 => true
 2 => false */
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
		if (flowerbed == null || flowerbed.isEmpty()) {
			throw new IllegalArgumentException("bed is empty");
		}

		if (numberToPlace == 0)
			return true;

		if (flowerbed.size() == 1) {
			return !flowerbed.get(0) && numberToPlace <= 1;
		}

		int counter = 0;

		for (int i = 0; i < flowerbed.size(); i++) {
			if (!flowerbed.get(i)) {
				if ((i == 0 && !flowerbed.get(i + 1))
						|| (i == flowerbed.size() - 1 && !flowerbed.get(i - 1))
						|| (!flowerbed.get(i + 1) && !flowerbed.get(i - 1))) {
					
					// place the flower
					flowerbed.set(i, true);
					counter++;
					if (counter == numberToPlace)
						return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		CanPlaceFlowers cf = new CanPlaceFlowers();
		List<Boolean> flowerbed = Arrays.asList(new Boolean[] { true, false,
				false, false, false, false, true, false, false });

		System.out.println(cf.canPlaceFlowers(flowerbed, 3));
		System.out.println(cf.canPlaceFlowers(flowerbed, 4));

		flowerbed = Arrays.asList(new Boolean[] { true, false, false, true,
				false, false, true, false, false });

		System.out.println(cf.canPlaceFlowers(flowerbed, 1));
		System.out.println(cf.canPlaceFlowers(flowerbed, 2));

		flowerbed = Arrays.asList(new Boolean[] { false });

		System.out.println(cf.canPlaceFlowers(flowerbed, 1));
		System.out.println(cf.canPlaceFlowers(flowerbed, 2));
	}

}
