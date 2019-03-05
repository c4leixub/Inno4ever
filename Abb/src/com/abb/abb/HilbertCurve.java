package com.abb.abb;

public class HilbertCurve {
	public int hilbertCurve(int x, int y, int n) {
		if (n == 0)
			return 0;

		int len = (int) Math.pow(2, n-1);
		int num = (int) Math.pow(4, n-1);
		
		if (x >= len && y >= len) {
			// 3 Shape is identical with previous iteration
			return 2 * num + hilbertCurve(x - len, y - len, n - 1);
		} else if (x < len && y >= len) {
			// 2 Shape is identical with previous iteration return num + hilbertCurve(x, y -
			// len, iter - 1);
		} else if (x < len && y < len) {
			// 1 Clock-wise rotate 90
			return hilbertCurve(y, x, n - 1);
		} else {
			// 4 Anti-Clockwise rotate 90
			return 3 * num + hilbertCurve(len - y - 1, 2 * len - x - 1, n - 1);
		}

		return 0;
	}

	public static void main(String[] args) {
		int a = (int) Math.pow(2, 3);
		int b = 1 << 3;

		System.out.println(a);
		System.out.println(b);
		
		a = (int) Math.pow(4, 3);
		b = 1 << (2 * 3);
		
		System.out.println(a);
		System.out.println(b);
	}
}
