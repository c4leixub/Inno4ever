package com.lkin.string.other;

public class ReverseWords {

	public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int st = 0, k = 0;
        char c;
        while (k < s.length()) { 
        	c = s.charAt(k);
        	if (c == ' ') {
        		reverse(sb, st, sb.length() - 1);
        		while (k < s.length() && s.charAt(k) == ' ') {
        			k++;
        		}
        		sb.append(' ');
        		st = sb.length();
        	} else {
        		sb.append(s.charAt(k));
        		k++;
        	}
        }
        reverse(sb, st, sb.length() - 1);
        
        reverse(sb, 0, sb.length() - 1);
        
        return sb.toString();
	}
	
	private void reverse(StringBuilder sb, int s, int e) {
        char t;
        while (s < e) {
            t = sb.charAt(s);
            sb.setCharAt(s, sb.charAt(e));//re[s] = re[e];
            sb.setCharAt(e, t);//re[e] = t;
            
            s++;
            e--;
        }
    }
	
	public static void main(String args[]) {
		ReverseWords r = new ReverseWords();
		String s = "the sky is blue";
		System.out.println(r.reverseWords(s));
	}
}
