package com.zeetcode.aafb.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks.Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 *
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class TaskScheduler {
	
	public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();        
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0)+1);
        }
        
        int maxFreq = 0, maxFreqCount = 0;
        for (char task : freq.keySet()) {
            if (freq.get(task) > maxFreq) {
                maxFreq = freq.get(task);
                maxFreqCount = 1;
            } else if (freq.get(task) == maxFreq) {
                maxFreqCount++;
            }
        }
        
        return Math.max(tasks.length,(maxFreq - 1) * (n+1) + maxFreqCount);
    }
	
	public int leastIntervalUsingHeap(char[] tasks, int n) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < tasks.length; i++) {
        	charCount.put(tasks[i], charCount.getOrDefault(tasks[i], 0)+1);
        }
        
        PriorityQueue<Character> queue = new PriorityQueue<Character>(
            new Comparator<Character>() {
                public int compare(Character c1, Character c2) {
                    if (charCount.get(c1).intValue() == charCount.get(c2).intValue()) {
                        return  c1.compareTo(c2);
                    }
                    
                    // the one with higher frequency in the front
                    return charCount.get(c2) - charCount.get(c1);
                }
            }
        );
        
        for (Character c : charCount.keySet()) {
            queue.add(c);
        }
        
        Set<Character> tmp = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            
            for (int i = 0; i < n + 1; i++) {
                if (queue.isEmpty()) {
                    if (charCount.size() == 0) {
                        System.out.println("1 Result is " + sb.toString());
                    	return sb.length();
                    } else {
                    	sb.append('|');
                    	continue;
                    }
                }
                
                Character c = queue.poll();
                sb.append(c);
                
                charCount.put(c, charCount.get(c)-1);
                if (charCount.get(c) > 0) {
                    tmp.add(c);
                } else {
                    charCount.remove(c);
                }
                
            }
            
            queue.addAll(tmp);
            tmp.clear();
        }
        
        System.out.println("2 Result is " + sb.toString());
        return sb.length();
    }
	
	public static void main(String[] args) {
		TaskScheduler t = new TaskScheduler();
		char[] tasks = new char[] {'A','A','A','B','B','B'};
		System.out.println(t.leastIntervalUsingHeap(tasks, 50));
		
		tasks = new char[] {'A','A','A','A','B','B','B','C','C','D','D','F','F','G'};
		System.out.println(t.leastIntervalUsingHeap(tasks, 2));
	}
}
