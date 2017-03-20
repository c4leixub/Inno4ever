package com.zeetcode.list.generation.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNum {
	private static HashMap<Character, String> digitToLettersMap 
								= new HashMap<Character, String>();
	static {
		digitToLettersMap.put('0', "");
		digitToLettersMap.put('1', "");
		digitToLettersMap.put('2', "abc");
		digitToLettersMap.put('3', "def");
		digitToLettersMap.put('4', "ghi");
		digitToLettersMap.put('5', "jkl");
		digitToLettersMap.put('6', "mno");
		digitToLettersMap.put('7', "pqrs");
		digitToLettersMap.put('8', "tuv");
		digitToLettersMap.put('9', "wxyz");
	};

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		res.add("");
		res = letterCombinationsHelper(res, digits);
		if (res.size() == 1) {
			res.clear();
		}
		return res;
	}

	private static List<String> letterCombinationsHelper(List<String> res,
			String digits) {
		if (digits.isEmpty())
			return res;

		String letters = digitToLettersMap.get(digits.charAt(0));
		List<String> tmp = new ArrayList<String>();
		for (String s : res) {
			for (char c : letters.toCharArray()) {
				tmp.add(s + c);
			}
		}
		return letterCombinationsHelper(tmp, digits.substring(1));
	}
}
