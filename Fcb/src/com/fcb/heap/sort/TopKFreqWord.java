package com.fcb.heap.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqWord {

	public List<String> topKFrequent(String[] words, int k) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				int val = map.get(o1) - map.get(o2);
                if (val == 0) {
					return o2.compareTo(o1);
				}
                
                return val;
			}
		});
		
		for (String word : map.keySet()) {
            pq.add(word);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
			result.add(pq.poll());
		}
		Collections.reverse(result);
		return result;
	} 
}
