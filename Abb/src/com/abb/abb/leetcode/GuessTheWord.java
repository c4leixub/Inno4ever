package com.abb.abb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class GuessTheWord {
	
	class Master {
		public int guess(String guess) {
			return RANDOM.nextInt(7);
		}
	}
	
	private static final Random RANDOM = new Random();
	
	public void findSecretWord(String[] wordlist, Master master) {
        
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[RANDOM.nextInt(wordlist.length)];
            
            /* 	minimax approach
        	HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist)
                for (String w2 : wordlist)
                    if (match(w1, w2) == 0)
                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
            
            String guess = "";
            Integer minimax = 1000;
            for (String w : wordlist)
                if (count.getOrDefault(w, 0) < minimax) {
                    guess = w;
                	minimax = count.getOrDefault(w, 0);
                }
            */
            
            x = master.guess(guess);
            
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist) {
                if (match(w, guess) == x) {
                    wordlist2.add(w);
                }
            }
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
    
    private int match(String guess, String w) {
        int match = 0;
        for (int i = 0; i < w.length(); i++) {
            if (guess.charAt(i) == w.charAt(i)) match++;
        }
        return match;
    }
}
