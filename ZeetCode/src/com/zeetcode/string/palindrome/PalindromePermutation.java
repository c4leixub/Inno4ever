package com.zeetcode.string.palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c)+1);
			} else {
				charCount.put(c, 1);
			}
        }
        
        boolean hasOneChar = false;
        for (char c : charCount.keySet()) {
            if (charCount.get(c) % 2 == 1 && hasOneChar) {
                return false;
            } else if (charCount.get(c) % 2 == 1) {
                hasOneChar = true;
            }
        }
        
        return true;
    }
	
	public List<String> generatePalindromes(String s) {
		List<String> result = new ArrayList<String>();
		
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c)+1);
			} else {
				charCount.put(c, 1);
			}
        }
        
        String candidate = "";
        String single = "";
        for (char c : charCount.keySet()) {
        	if (charCount.get(c) % 2 == 1 && !single.isEmpty()) {
                return result;
            } else if (charCount.get(c) % 2 == 1) {
            	single += c;
            }
        	
        	int num = charCount.get(c) / 2;
        	for(int i = 0; i < num; i++) {
        		candidate += c;
        	}
        }
        
        if(candidate.length() == 0 && single.length() != 0) {
        	result.add(single);
            return result;
        }
        
        help("", candidate, single, candidate.length(), result);
        return result;
    }
	
	public void help(String left, String candidate, String single, int l, List<String> result) {
		if (left.length() == l) {
			String right = new StringBuffer(left).reverse().toString();
			result.add(left + single + right);
		}
		
		for (int i = 0; i < candidate.length(); i++) {
			if (i > 0 && candidate.charAt(i) == candidate.charAt(i - 1)) {
				continue;
			}
			
			help(left+candidate.charAt(i),
					candidate.substring(0, i) + candidate.substring(i + 1),
					single, l, result);
		}
	}
	
	public static void main(String[] args) {
		PalindromePermutation p = new PalindromePermutation();
		System.out.println(p.generatePalindromes("aaaabbbbc"));
	}
}
