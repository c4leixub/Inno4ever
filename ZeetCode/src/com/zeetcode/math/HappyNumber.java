package com.zeetcode.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> tested = new HashSet<Integer>();

		while (n != 1) {
			if (tested.contains(n)) {
				return false;
			}

			tested.add(n);
			n = sumSquareDigit(n);
		}

		return true;
	}

	public int sumSquareDigit(int n) {
		int re = 0;
		while (n != 0) {
			re += (n % 10) * (n % 10);
			n = n / 10;
		}

		return re;
	}

	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
		System.out.println(h.sumSquareDigit(82));
		System.out.println(h.sumSquareDigit(100));
	}

}
