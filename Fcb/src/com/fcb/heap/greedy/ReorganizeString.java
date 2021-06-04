package com.fcb.heap.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
	public String reorganizeString(String S) {
        
        if (S == null || S.length() <= 1) {
            return S;
        }
        
        int[] charCounts = new int[26];
        char c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            charCounts[c - 'a']++; 
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return charCounts[o2.charValue() - 'a'] - charCounts[o1.charValue() - 'a'];
			}
        });
        for (int i = 0; i < 26; i++) {
        	if (charCounts[i] == 0) continue;	// only interested in char with counts > 0

        	if (charCounts[i] > (S.length() + 1) / 2) {
        		return "";		// impossible case
        	}
        	pq.add((char)('a' + i));
        }
        
        StringBuilder sb = new StringBuilder();
        Character c1 , c2;
        while (pq.size() >= 2) {
        	c1 = pq.poll();
        	c2 = pq.poll();
        	
        	sb.append(c1);
        	sb.append(c2);
        	
        	charCounts[c1.charValue() - 'a']--;
        	if (charCounts[c1.charValue() - 'a'] > 0) {
        		pq.add(c1);
        	}
        	
        	charCounts[c2.charValue() - 'a']--;
        	if (charCounts[c2.charValue() - 'a'] > 0) {
        		pq.add(c2);
        	}
        }
        
        if (pq.size() > 0) {
        	sb.append(pq.poll());
        }
        
        return sb.toString();
        
        /*
        List<Character> chars = new ArrayList<>(charCounts.keySet());
        Collections.sort(chars, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return charCounts.get(o1) - charCounts.get(o1);
			}
        });
        
        
        char[] res = new char[S.length()];
        int count, t = 1;
        for (Character ch : chars) {
        	count = charCounts.get(ch);
        	
        	if (count > (S.length() + 1) / 2) {
        		return "";
        	}
        	
        	for (int i = 0; i < count; i++) {
        		if (t >= S.length()) t = 0;
        		res[t] = ch;
                t += 2;
        	}
        }
        
        return String.valueOf(res);
        */
    }
	
}
