package com.lkin.math;

public class ReverseInteger {
	public int reverse(int x) {
        long result = 0, m = x < 0 ? -1 : 1;
        if (x < 0) {
            x *= -1;
        }
        
        while (x != 0) {
            int r = x % 10;
            result = result * 10 + r;
            x = x / 10;
        }
        
        result = result * m;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) result;
    }
}
