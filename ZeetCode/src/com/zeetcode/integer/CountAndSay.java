package com.zeetcode.integer;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

 */
public class CountAndSay {
	public static String countAndSay(int n) {
		if (n == 0) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer(",");
		String s = "1";
		sb.append(s);
		int i = 0;
		while (i < n) {
			s = countAndSayhelper(s);
			sb.append(", ");
			sb.append(s);
			i++;
		}
		
		return sb.substring(1);
	}
	
	public static String countAndSayhelper(String s) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char c = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count++;
			} else {
				sb.append(count);
				sb.append(c);
				c = s.charAt(i);
				count = 1;
			}
		}
		
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
	}
}
