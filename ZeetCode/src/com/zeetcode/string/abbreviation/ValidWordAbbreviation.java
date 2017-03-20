package com.zeetcode.string.abbreviation;

public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, count;
        char c;
        while (i < word.length() && j < abbr.length()) {
        	if (Character.isDigit(abbr.charAt(j))) {
        		// first digit must not be 0
        		if (abbr.charAt(j) == '0')	return false;
        		
        		// compute the in after the letter
        		count = 0;
        		while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
        			c = abbr.charAt(j);
        			count = count * 10 + (c - '0');
        			j++;
        		}
        		
        		i += count;
        	} else {
        		if (i >= word.length() || word.charAt(i) != abbr.charAt(j)) {
        			return false;
        		}
        		i++;
        		j++;
        	}
        }
        
        return i == word.length() && j == abbr.length();
    }
	
	public static void main(String[] args) {
		String s = "a", abbr = "01";
		ValidWordAbbreviation v = new ValidWordAbbreviation();
		System.out.println(v.validWordAbbreviation(s, abbr));

	}

}
