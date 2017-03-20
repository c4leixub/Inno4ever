package com.zeetcode.integer.finding;

public class UglyNumber {
	public int nthUglyNumber(int n) {
        if (n < 1)  return -1;
        if (n == 1) return 1;
        
        
        int re = 1;
        int j = 1;
        while (j <= n) {
        	System.out.println(j + " " + re);
            if (re == 1 || re % 2 == 0 ||  re % 3 == 0 || re % 5 == 0) {
                j++;
            }
            if (j > n)  break;
            
            re++;
        }
        
        System.out.println(j + " " + re);
        
        return re;
    }
	
	public static void main(String[] args) {
		UglyNumber u = new UglyNumber();
		System.out.println(u.nthUglyNumber(11));
	}
}
