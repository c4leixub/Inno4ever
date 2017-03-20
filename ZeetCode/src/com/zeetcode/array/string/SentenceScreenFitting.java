package com.zeetcode.array.string;

import java.util.ArrayList;
import java.util.List;

public class SentenceScreenFitting {

	public int wordsTyping(String[] sentence, int rows, int cols) {
		if (sentence == null || sentence.length == 0) {
			return 0;
		}

		StringBuilder all = new StringBuilder();
		for (String word : sentence) {
			all.append(word);
			all.append(' ');
		}

		int start = 0, len = all.length();
		for (int i = 0; i < rows; i++) {
			start += cols;

			if (all.charAt(start % len) == ' ') {
				start++;
			} else {
				while (start > 0 && all.charAt((start - 1) % len) != ' ') {
					start--;
				}
			}
		}

		return start / len;
	}

	public int wordsTypingMine(String[] sentence, int rows, int cols) {
		int count = 0;
		int k = 0;

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < rows; i++) {
			int j = 0;
			while (j < cols) {
				if (j + sentence[k].length() > cols) {
					j++;
				} else {
					j += sentence[k].length();
					if (j < cols) {
						j++;
					}

					k++;
					if (k == sentence.length) {
						k = 0;
						count++;
					}
				}
			}

			// String t = "";
			// while (t.length() < cols) {
			// if (t.length() + sentence[k].length() > cols) {
			// t += "-";
			// } else {
			// t += sentence[k];
			// if (t.length() < cols) {
			// t += "-";
			// }
			//
			// k++;
			// if (k == sentence.length) {
			// k = 0;
			// count++;
			// }
			// }
			// }
			//
			// list.add(t);
		}

		System.out.println(list);
		return count;
	}

	public static void main(String[] args) {
		String[] sentence = new String[] { "I", "had", "apple", "pie" };
		int rows = 4;
		int cols = 5;

		rows = 3;
		cols = 6;
		sentence = new String[] { "a", "bcd", "e" };

		SentenceScreenFitting s = new SentenceScreenFitting();
		System.out.println(s.wordsTyping(sentence, rows, cols));
	}
}
