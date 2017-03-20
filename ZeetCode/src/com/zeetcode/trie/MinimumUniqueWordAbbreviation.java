package com.zeetcode.trie;

import java.util.ArrayList;
import java.util.List;

public class MinimumUniqueWordAbbreviation {

	public class TrieAbbr extends Trie{

		public TrieAbbr() {
			super();
		}

		public boolean isAbbr(String abbr) {
			return isAbbr(super.root, abbr, 0);
		}

		public boolean isAbbr(TrieNode p, String abbr, int num) {
			if (num == 0) {
				if (abbr.length() == 0) { // at the end of the abbr
					return p.isEnd;
				}

				// if we see a number again, get the number of char to combine
				int i = 0, newNum = 0;
				while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
					newNum = newNum * 10 + (abbr.charAt(i) - '0');
					i++;
				}

				if (newNum > 0) {
					return isAbbr(p, abbr.substring(i), newNum);
				} else {
					if (p.nodes[abbr.charAt(0) - 'a'] != null) {
						return isAbbr(p.nodes[abbr.charAt(0) - 'a'],
								abbr.substring(1), 0);
					} else {
						return false;
					}
				}
			}

			for (TrieNode node : p.nodes) {
				if (node != null && isAbbr(node, abbr, num - 1)) {
					return true;
				}
			}
			return false;
		}
	}

	// DFS with backtracking
	private void getAbbs(char[] cc, int s, int len, StringBuilder sb,
			List<String> abbs) {
		boolean preNum = (sb.length() > 0) && Character.isDigit(sb.charAt(sb.length() - 1) );

		if (len == 1) {
			if (s < cc.length) {
				if (s == cc.length - 1)
					abbs.add(sb.toString() + cc[s]); // add one char
				if (!preNum)
					abbs.add(sb.toString() + (cc.length - s)); // add a number
			}
		} else if (len > 1) {
			int last = sb.length();
			for (int i = s + 1; i < cc.length; i++) {
				if (!preNum) { // add a number
					sb.append(i - s);
					getAbbs(cc, i, len - 1, sb, abbs);
					sb.delete(last, sb.length());
				}
				if (i == s + 1) { // add one char
					sb.append(cc[s]);
					getAbbs(cc, i, len - 1, sb, abbs);
					sb.delete(last, sb.length());
				}
			}
		}
	}

	public String minAbbreviation(String target, String[] dictionary) {
		TrieAbbr trie = new TrieAbbr();
		for (String s : dictionary) {
			trie.insert(s);
		}

		int len = target.length();
		char[] cc = target.toCharArray();
		String ret = null;
		int min = 1, max = len, mid;
		while (min <= max) {
			mid = min + (max - min) / 2;
			List<String> abbs = new ArrayList<String>();
			getAbbs(cc, 0, mid, new StringBuilder(), abbs);

			boolean isConflict = true;
			for (String abbr : abbs) {
				if (!trie.isAbbr(abbr)) {
					isConflict = false;
					ret = abbr;
					break;
				}
			}

			if (isConflict) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		String t = "apple";
		String[] d = new String[] { "blade" };

		MinimumUniqueWordAbbreviation m = new MinimumUniqueWordAbbreviation();
		System.out.println(m.minAbbreviation(t, d));

	}
}
