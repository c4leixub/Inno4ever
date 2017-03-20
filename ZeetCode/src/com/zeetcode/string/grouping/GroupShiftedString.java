package com.zeetcode.string.grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], A
 * solution is: [["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"]]
 */
public class GroupShiftedString {
	public List<List<String>> groupStrings(String[] strings) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strings) {
			String key = getKey(s);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}

		List<List<String>> result = new ArrayList<List<String>>();
		for (String key : map.keySet()) {
			result.add(map.get(key));
		}

		return result;
	}

	private String getKey(String s) {
		char[] arr = s.toCharArray();
		if (arr.length > 0) {
			int diff = arr[0] - 'a';
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (char) (arr[i] - diff);

				if (arr[i] < 'a') {
					arr[i] = (char) (arr[i] + 26);
				}

			}
		}
		return new String(arr);
	}
}
