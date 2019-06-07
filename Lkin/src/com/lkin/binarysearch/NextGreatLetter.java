package com.lkin.binarysearch;

/**
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that
 * is larger than the given target.
 * 
 * Letters also wrap around. For example, if the target is target = 'z' and
 * letters = ['a', 'b'], the answer is 'a'.
 */
public class NextGreatLetter {
	public char nextGreatestLetter(char[] letters, char target) {
		int lo = 0, hi = letters.length;
		while (lo < hi) {
			int mi = lo + (hi - lo) / 2;
			if (letters[mi] <= target)
				lo = mi + 1;
			else
				hi = mi;
		}
		return letters[lo % letters.length];
	}
}
