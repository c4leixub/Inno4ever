package com.zeetcode.math;

public class PowOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n == 1)	return true;
		if (n % 2 == 1) return false;
		
		return isPowerOfTwo(n/2);
	}
	
	public static void main(String[] args) {
		PowOfTwo p = new PowOfTwo();
		System.out.println(p.isPowerOfTwo(10));
		System.out.println(p.isPowerOfTwo(9));
		System.out.println(p.isPowerOfTwo(8));
		System.out.println(p.isPowerOfTwo(1));
	}
}
