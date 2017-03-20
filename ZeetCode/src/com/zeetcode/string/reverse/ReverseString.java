package com.zeetcode.string.reverse;

public class ReverseString {
	
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}

	public void reverseWordsInPlace(char[] s) {
		
		// reverse each word
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
		reverse(s, i, s.length - 1);	// reverse the last word

		reverse(s, 0, s.length - 1);	// reverse the while s
	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		char[][] board = new char[2][3];
		System.out.println("'"+board[0][0]+"'");
	}
}
