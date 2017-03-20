package com.zeetcode.math;

public class Pow {
	public double pow(double x, int n) {
		if (n < 0) {
    		return 1.0 / power(x, -n);
    	} else {
    		return power(x, n);
    	}
	}
	
	// n >= 0
	public double power(double x, int n) {
    	if (n == 0) return 1;
    	if (n == 1) return x;
     
    	double v = power(x, n / 2);
     
    	if (n % 2 == 0) {
    		return v * v;
    	} else {
    		return v * v * x;
    	}
    }
}
