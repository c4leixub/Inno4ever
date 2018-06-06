package com.zeetcode.aafb.String;

public class IntegerToExcelCol {
	public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        
        char c;
        int r;
        while (n > 0) {
            r = n % 26;
            if (r == 0) {
                s.append('Z');
                n -= 26;
            } else {
                c = (char) ('A' + (r-1)); 
                s.append(c);
                n -= r;
            }
            n /= 26;
        }
        s.reverse();
        return s.toString();
    }
	
	public int titleToNumber(String s) {
        if (s.length() == 0) return 0;
        
        int res = s.charAt(0) - 'A' + 1;
        int i = 1;
        while (i < s.length()) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
            i++;
        }
        return res;
    }
}
