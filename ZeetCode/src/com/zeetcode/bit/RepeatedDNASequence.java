package com.zeetcode.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 * repeated sequences within the DNA. Write a function to find all the 10-letter-long
 * sequences (substrings) that occur more than once in a DNA molecule.

For example,	Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
Return:	["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() < 10) return result;
		
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		int i = 0;
		while (i+10 <= s.length()) {
			String k = s.substring(i, i+10);
			if (m.containsKey(k)) {
				m.put(k, m.get(k)+1);
				if (m.get(k) == 2)	result.add(k);
			} else {
				m.put(k, 1);
			}
			i++;
		}
		
		return result;
	}
	
	public List<String> findRepeatedDnaSequencesBit(String s) {
		List<String> result = new ArrayList<String>();
	 
		int len = s.length();
		if (len < 10) {
			return result;
		}
	 
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
	 
		Set<Integer> temp = new HashSet<Integer>();
		Set<Integer> added = new HashSet<Integer>();
	 
		int hash = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				//each ACGT fit 2 bits, so left shift 2
				hash = (hash << 2) + map.get(s.charAt(i)); 
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				//make length of hash to be 20
				hash = hash &  (1 << 20) - 1; 
	 
				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash); //track added
				} else {
					temp.add(hash);
				}
			}
	 
		}
	 
		return result;
	}
	
	public static void main(String[] args) {
		RepeatedDNASequence r = new RepeatedDNASequence();
		System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
