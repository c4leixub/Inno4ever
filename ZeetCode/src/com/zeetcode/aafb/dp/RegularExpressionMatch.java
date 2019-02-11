package com.zeetcode.aafb.dp;

public class RegularExpressionMatch {
	public boolean isMatchOld(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
				return false;
			}
			return isMatchOld(s.substring(1), p.substring(1));

		} else {
			int len = s.length();

			int i = -1;
			while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatchOld(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;

		}
	}

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		if (p.length() == 1) {
			return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		}

		if (p.charAt(1) != '*') {
			if (s.isEmpty()) {
				return false;
			}
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}

		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2)))
				return true;
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));

	}

	public boolean isMatchSimplify(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		
		if (p.length() > 1 && p.charAt(1) == '*') {
			return this.isMatch(s, p.substring(2)) || (!s.isEmpty()
					&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p));
		}

		return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
				&& isMatch(s.substring(1), p.substring(1));
	}
}
