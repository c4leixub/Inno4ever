package com.lkin.binarysearch;

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num < 1)
			return false;
		
		if (num == 1)
			return true;
		
		int left = 0, right = num / 2;
		while (left <= right) {
			long mid = (left + right) / 2;
			long val = mid * mid;
			if (val == num)
				return true;
			else if (val > num)
				right = ((int) mid) - 1;
			else
				left = ((int) mid) + 1;
		}
		return false;
	}
}