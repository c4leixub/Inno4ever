package com.zeetcode.string.linkedin;

/**
 * Validate if a given string is numeric. Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
        int len = s.length();
        int i = 0, e = len - 1;
        
        // eleminate the space in the front
        while (i < len && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        
        // reach to the end after eleminate the space in front
        if (i >= len) {
            return false;
        }
        
        // eleminate the space at the back
        while (i <= e && Character.isWhitespace(s.charAt(e))) {
        	e--;
        }
        
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
        	i++;
        }
        
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'
        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if(exp || dot) return false;
                dot = true;
            } else if (c == 'e') {
                if(exp || !num) return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
            i++;
        }
		return num;
	}
}
