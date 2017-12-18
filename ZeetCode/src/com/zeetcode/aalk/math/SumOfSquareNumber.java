package com.zeetcode.aalk.math;

public class SumOfSquareNumber {
	
	// check whether c = a * a + b * b
	public boolean judgeSquareSum(int c) {
        // int A = (int) Math.sqrt(c), b = 0, d = 0;
        // for (int a = 0; a <= A; a++) {
        //     d = c - a * a;
        //     b = (int) Math.sqrt(d);
        //     if (b * b == d) {
        //         return true;
        //     }
        // }
        
        int a = 0, b = (int) Math.sqrt(c), sum = 0;
        while (a <= b) {
            sum = a*a + b*b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }
        
        return false;
    }
}	
