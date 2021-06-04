package com.twt.zpdm.string;

import java.util.*;

public class TextSplit {

	public List<String> split(String text, int limit) {

		String suffix = " (x/x)";
		List<StringBuilder> lines;

		int loop = 1;
		while (true) {
			lines = split(text, limit, suffix);

			if (lines.size() >= Math.pow(10, loop)) {
				loop++;
				suffix = " (xx/xx)";
				lines = new ArrayList<>();
			} else {
				break;
			}
		}

		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).append("(").append(i + 1).append("/").append(lines.size()).append(')');
		}

		List<String> result = new ArrayList<>(lines.size());
		for (StringBuilder line : lines) {
			result.add(line.toString());
		}

		return result;
	}
	
	public List<StringBuilder> split(String text, int limit, String suffix) {
		String[] words = text.split("\\s+");
		int suffixLength = suffix.length();
		
		int index = 0;
		StringBuilder sb;
		List<StringBuilder> sbs = new ArrayList<>();
		while (index < words.length) {
			sb = new StringBuilder();
			while (index < words.length
					&& (sb.length() + words[index].length() + suffixLength) <= limit) {
				sb.append(words[index]).append(' ');
				index++;
			}
			sbs.add(sb);
		}
		
		return sbs;
	}

	public static void main(String[] args) {
		String test = "Write a function that splits long SMS string into (1/5)";
		System.out.println(test.length());

		String example_text = "Write a function that splits long SMS string"
				+ " into smaller pieces. Each piece should be less than or "
				+ "equal to 160 characters and contains indices at the end."
				+ " Function should not break words into pieces. If word does"
				+ " not fit -- it should go to the next SMS.";
		System.out.println(example_text.length());

		TextSplit t = new TextSplit();
		List<String> list;
		list = t.split(example_text, 60);
		for (String s : list) {
			System.out.println(s + " " + s.length());
		}

		System.out.println();
		
//		List<StringBuilder> sbs = t.split(example_text, 60, " (x/x)");
//		for (StringBuilder s : sbs) {
//			System.out.println(s.toString() + " " + s.length());
//		}

		System.out.println("smaller pieces. Each piece should be less than or equal".length());

//		example_text = "Write a function that splits long SMS string"
//				+ " into smaller pieces. Each piece should be less than or "
//				+ "equal to 160 characters and contains indices at the end."
//				+ " Function should not break words into pieces. If word does"
//				+ " not fit -- it should go to the next SMS." 
//				+ "Write a function that splits long SMS string"
//				+ " into smaller pieces. Each piece should be less than or "
//				+ "equal to 160 characters and contains indices at the end."
//				+ " Function should not break words into pieces. If word does"
//				+ " not fit -- it should go to the next SMS."
//				+ "Write a function that splits long SMS string"
//				+ " into smaller pieces. Each piece should be less than or "
//				+ "equal to 160 characters and contains indices at the end."
//				+ " Function should not break words into pieces. If word does"
//				+ " not fit -- it should go to the next SMS.";
//		list = t.split(example_text, 60);
//		for (String s : list) {
//			System.out.println(s + " " + s.length());
//		}
	}
}
