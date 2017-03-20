package com.zeetcode.string.palindrome;

public class ShortestPalindrom {
	public String shortestPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (j >= 0) {
        	if (s.charAt(i) == s.charAt(j)) {
        		i++;
        	}
        	j--;
        }
        
        if (i == s.length()) {
        	return s;
        }
        
        String suffix = s.substring(i); // 后缀不能够匹配的字符串
        String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配
        String mid = shortestPalindrome(s.substring(0, i)); //递归调用找 [0,j]要最少可以补充多少个字符让他回文
        String ans = prefix + mid  + suffix;
        return  ans;
    }
	
	public static void main(String[] args) {
		String s = "abxyzba";
		ShortestPalindrom p = new ShortestPalindrom();
		System.out.print(p.shortestPalindrome(s));
	}
}
