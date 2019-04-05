package com.lkin.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFrequency {
	public String frequencySortHeap(String s) {
		
		final Map<Character, Integer> counts = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Character> heap = new PriorityQueue<Character>(counts.size(), new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return counts.get(o2) - counts.get(o1);
			}
		});
		
		for (Character c: counts.keySet()) {
			heap.add(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!heap.isEmpty()) {
			Character c = heap.poll();
			for (int i = 0; i < counts.get(c); i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String frequencySort(String s) {
		Character c;
		int max = 0, count = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
			max = Math.max(max, count);
		}

		List<Character>[] countToChars = new List[max + 1];
		for (Character ch : map.keySet()) {
			count = map.get(ch);
			if (countToChars[count] == null) {
				countToChars[count] = new ArrayList<Character>();
			}
			countToChars[count].add(ch);
		}

		StringBuilder sb = new StringBuilder();
		for (count = max; count > 0; count--) {
			if (countToChars[count] == null) {
				continue;
			}

			for (int i = 0; i < countToChars[count].size(); i++) {
				c = countToChars[count].get(i);
				for (int j = 0; j < count; j++) {
					sb.append(c);
				}
			}
		}

		return sb.toString();
	}
}
