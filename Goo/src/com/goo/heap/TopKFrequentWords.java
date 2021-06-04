package com.goo.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new LinkedList<String>();
		if (words == null || words.length == 0 || k == 0) {
			return result;
		}

		// O(n)
		final Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String word : words) {
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> heap = new PriorityQueue<String>(k, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int val = counts.get(o1) - counts.get(o2);
				if (val == 0) {
					// two words with the same count, make the it reverse alphabetic order
					// so in the result it will become alphabetic order
					return -1 * o1.compareTo(o2);
				}
				return val;
			}
		});

		// O(n log k)
		for (String word : counts.keySet()) {
			heap.add(word);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		while (!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result);

		return result;
	}
	
	public static void main(String[] args) {
		String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "if", "if", "if"};
		
		TopKFrequentWords w = new TopKFrequentWords();
		System.out.println(w.topKFrequent(words, 4));
	}
}
