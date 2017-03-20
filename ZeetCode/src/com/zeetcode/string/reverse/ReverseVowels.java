package com.zeetcode.string.reverse;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
	
	private static HashSet<Character> VOWELS = new HashSet<Character>(Arrays.asList(
			new Character('a'), new Character('e'), new Character('i'),
			new Character('o'), new Character('u'),
			new Character('A'), new Character('E'), new Character('I'),
			new Character('O'), new Character('U')));
 	
	public String reverseVowels(String str) {
        if (str == null || str.length() <= 1) {
        	return str;
        }
		
        char[] charArray = str.toCharArray();
        int s = 0;
        int e = str.length() - 1;
        
        while (s < e) {
            if (!VOWELS.contains(charArray[s])) {
            	s++;
            }
            
            if (!VOWELS.contains(charArray[e])) {
            	e--;
            }
            
            if (VOWELS.contains(charArray[s]) && VOWELS.contains(charArray[e])) {
            	char c = charArray[s];
            	charArray[s] = charArray[e];
            	charArray[e] = c;
            	s++;
            	e--;
            }
        }
        
        return new String(charArray);
    }
}
