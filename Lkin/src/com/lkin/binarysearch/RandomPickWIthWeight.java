package com.lkin.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of
 * index i, write a function pickIndex which randomly picks an index in
 * proportion to its weight.
 */
public class RandomPickWIthWeight {

	List<Integer> psum = new ArrayList<Integer>();
	int tot = 0;
	Random rand = new Random();

	public RandomPickWIthWeight(int[] w) {
		for (int x : w) {
			tot += x;
			psum.add(tot);
		}
	}

	public int pickIndex() {
		int targ = rand.nextInt(tot);

		int lo = 0;
		int hi = psum.size() - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (targ >= psum.get(mid)) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
