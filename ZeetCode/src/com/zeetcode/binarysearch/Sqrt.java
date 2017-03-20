package com.zeetcode.binarysearch;

public class Sqrt {
	public int sqrt(int x) {
		long start = 1, end = x;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid < x) {
				start = mid;
			} else if (mid * mid > x) {
				end = mid;
			} else {
				return (int) mid;
			}
		}

		if (end * end <= x) {
			return (int) end;
		}

		return (int) start;
	}

	public boolean isPerfectSquare(int x) {
		long start = 0, end = x;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			if (mid * mid < x) {
				start = mid + 1;
			} else if (mid * mid > x) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
