package com.zeetcode.string.decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length());
			sb.append('#');
			sb.append(s);
		}

		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> result = new ArrayList<String>();
		
		int i = 0, len = 0;
		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			// find the length of a string
			while (i < s.length() && s.charAt(i) != '#') {
				len = len * 10 + (s.charAt(i) - '0');
				i++;
			}

			// skip the # char
			i++;
			
			// grep the next 'len' chars
			while (len > 0 && i < s.length()) {
				sb.append(s.charAt(i));
				i++;
				len--;
			}

			result.add(sb.toString());
			sb = new StringBuilder();
		}

		return result;
	}

	public static void main(String[] args) {
		EncodeDecodeString eds = new EncodeDecodeString();
		List<String> strs = Arrays.asList("abc", "def", "kop");
		String s = eds.encode(strs);
		System.out.println(s);
		System.out.println(eds.decode(s));
	}
}
