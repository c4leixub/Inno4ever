package com.zeetcode.math;

public class SuperPow {
	public int superPow(int a, int[] b) {
		if (b.length == 0) return 1;
        
		int mod = 1337;
		int pow10Mod = power(a, 1, mod);
        int result = 1;
        
        for (int i = b.length-1; i >= 0; i--) {        
        	result = result * power(pow10Mod, b[i], mod);
        	result = result % mod;
        	pow10Mod = power(pow10Mod, 10, mod);
        }
        
        return result;
    }
    
    public int power(int x, int n, int mod) {
    	if (n == 0) return 1;
    	if (n == 1) return x % mod;
     
    	int v = power(x, n / 2, mod);
     
    	if (n % 2 == 0) {
    		return v * v % mod;
    	} else {
    		return v * v * x % mod;
    	}
    }
    
    public static void main(String[] args) {
    	SuperPow s = new SuperPow();
    	System.out.println(s.superPow(2147483647, new int[] {2,0,0}));
    	System.out.println(100 % 1337);
    }
}
