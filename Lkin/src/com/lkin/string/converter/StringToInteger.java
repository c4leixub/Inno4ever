package com.lkin.string.converter;

public class StringToInteger {
	public int myAtoi(String str) {
        double re = 0.0;    
        int i = 0;
        
        // handle white space
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        if (i >= str.length()) {	// check end of string
			return 0;
		}
        
        // handle sign
        int m = 1;
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			if (str.charAt(i) == '-') {
				m = -1;
			}
			i++;
		}
        if (i >= str.length()) {	// check end of string
			return 0;
		}
        
        char c;
        while (i < str.length()) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                re = re * 10 + (c-'0');
            } else {	
                break;	// stop when we see non-digit
            }
            
            i++;
        }
        
        re = m * re;

		// handle max and min
		if (re > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (re < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
        
        return (int) re;
    }
}
