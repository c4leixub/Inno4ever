package com.lkin.math;

public class Pow {
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / pow(x, -1 * n);
		}

		return pow(x, n);
	}

	public double pow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}

		if (n == 1) {
			return x;
		}

		double v = pow(x, n / 2);
		double result = v * v;

		if (n % 2 != 0) {
			result *= x;
		}

		return result;
	}
}
