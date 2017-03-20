package com.zeetcode.array.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();

		if (words == null || words.length == 0) {
			return result;
		}

		int count = 0;
		int last = 0;
		for (int i = 0; i < words.length; i++) {
			count = count + words[i].length();

			if (count + i - last > maxWidth) {
				int wordsLen = count - words[i].length();
				int spaceLen = maxWidth - wordsLen;
				int eachLen = 1;
				int extraLen = 0;

				if (i - last - 1 > 0) {
					eachLen = spaceLen / (i - last - 1);
					extraLen = spaceLen % (i - last - 1);
				}

				StringBuilder sb = new StringBuilder();

				for (int k = last; k < i - 1; k++) {
					sb.append(words[k]);

					int ce = 0;
					while (ce < eachLen) {
						sb.append(ONE_SPACE);
						ce++;
					}

					if (extraLen > 0) {
						sb.append(ONE_SPACE);
						extraLen--;
					}
				}

				sb.append(words[i - 1]);// last words in the line
				// if only one word in this line, need to fill left with space
				while (sb.length() < maxWidth) {
					sb.append(ONE_SPACE);
				}

				result.add(sb.toString());

				last = i;
				count = words[i].length();
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = last; i < words.length - 1; i++) {
			count = count + words[i].length();
			sb.append(words[i] + ONE_SPACE);
		}

		sb.append(words[words.length - 1]);
		while (sb.length() < maxWidth) {
			sb.append(ONE_SPACE);
		}
		result.add(sb.toString());

		return result;
	}

	public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String[] words = new String[] { "This", "is", "an", "example", "of",
				"text", "justification re." };
		//for (String s : t.fullJustify(words, 16)) {
		for (String s : t.justify(words, 16)) {
			System.out.println("\"" + s + "\"");
		}
	}
	
	private static final String ONE_SPACE = " ";
	
	public List<String> justify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		
		if (words == null || words.length == 0) {
			return result;
		}
		
		int count = 0;
		int first = 0;
		int numGap = 0;
		for (int i = 0; i < words.length; i++) {
			count += words[i].length();
			numGap = i - first;
			
			if (count + numGap > maxWidth) {
				int wordLen = count - words[i].length();
				int spaceLen = maxWidth - wordLen;
				
				int eachLen = 1;
				int extraLen = 0;
				if (numGap - 1 > 0) {
					eachLen = spaceLen / (numGap - 1);
					extraLen = spaceLen % (numGap - 1);
				}
				
				result.add(justifyHelper(words, first, i-1, eachLen, extraLen, maxWidth));
				
				first = i;
				count = words[i].length();
			}
		}
		
//		int spaceLen = maxWidth - count;
//		int eachLen = 1;
//		int extraLen = 0;
//		if (numGap - 1 > 0) {
//			eachLen = spaceLen / (numGap - 1);
//			extraLen = spaceLen % (numGap - 1);
//		}
//		result.add(justifyHelper(words, first, words.length-1, eachLen, extraLen, maxWidth));
		
		result.add(justifyHelper(words, first, words.length-1, 1, 0, maxWidth));
		
		return result;
	}
	public String justifyHelper(String[] words, int first, int last, int eachLen, int extraLen, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = first; i <= last - 1; i++) {
			sb.append(words[i]);
			
			// add spaces
			int ce = 0;
			while (ce < eachLen) {
				sb.append(ONE_SPACE);
				ce++;
			}
			
			// add extra space if any
			if (extraLen > 0) {
				sb.append(ONE_SPACE);
				extraLen--;
			}
		}
		
		sb.append(words[last]);	// add last word
		
		// only one word in a line, add space at the back
		while (sb.length() < maxWidth) {
			sb.append(ONE_SPACE);
		}
		
		return sb.toString();
	}
}
