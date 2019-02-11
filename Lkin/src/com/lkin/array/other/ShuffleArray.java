package com.lkin.array.other;

import java.util.Random;

public class ShuffleArray {
	private int[] array;
	private int[] original;

	private Random random;

	public ShuffleArray(int[] nums) {
        array = nums;
        original = array.clone();
        random = new Random();
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			array[i] = original[i];
		}
		return array;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int j = i + random.nextInt(n - i);

			// swap i and j
			int t = array[i];
			array[i] = array[j];
			array[j] = t;
		}

		return array;
	}
}
