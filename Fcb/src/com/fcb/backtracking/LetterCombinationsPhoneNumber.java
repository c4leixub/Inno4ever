package com.fcb.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
	private static Map<Character, char[]> map = new HashMap<Character, char[]>();
	static {
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		dfs(digits, 0, new StringBuilder(), result);

		return result;
	}

	public void dfs(String digits, int i, StringBuilder sb, List<String> result) {
		if (i == digits.length()) {
			result.add(sb.toString());
			return;
		}

		for (char c : map.get(digits.charAt(i))) {
			sb.append(c);
			dfs(digits, i + 1, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
