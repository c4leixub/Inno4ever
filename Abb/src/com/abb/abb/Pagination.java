package com.abb.abb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Pagination {
	
	// complexity O(n^2) , space O(n)
	public List<String> displayPages(List<String> input, int pageSize) {	
		LinkedList<String> res = new LinkedList<>();
		Iterator<String> iter = input.iterator();
		Set<String> set = new HashSet<>();
		boolean reachEnd = false;
		int counter = 0;
		while (iter.hasNext()) {
			String cur = iter.next();
			String id = (cur.split(","))[0];
			if (!set.contains(id) || reachEnd) {
				res.add(cur);
				set.add(id);
				iter.remove();
				counter++;
			}
			if (counter == pageSize) {
				set.clear();
				counter = 0;
				reachEnd = false;
				iter = input.iterator();
			}
			if (!iter.hasNext()) {
				reachEnd = true;
				iter = input.iterator();
			}
		}
		return res;
	}
	
	class Entry {
		String listing;
		double score;
		public Entry(String listing, double score) {
			super();
			this.listing = listing;
			this.score = score;
		}
	}
	public List<List<String>> pagination(List<String> input, int pageSize) { // O(n _ nlogn)
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, LinkedList<Entry>> m = new HashMap<String, LinkedList<Entry>>();
		String[] tmp;
		for (String cur : input) {
			tmp = cur.split(",");
			if (!m.containsKey(tmp[0])) {
				m.put(tmp[0], new LinkedList<Entry>());
			}
			m.get(tmp[0]).addLast(new Entry(cur, Double.parseDouble(tmp[2])));
		}
		
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				double score1 = m.get(o1).peek().score;
				double score2 = m.get(o2).peek().score;
				if (score1 > score2) {
					return -1;
				} else if (score1 < score2) {
					return 1;
				}
				
				return 0;
			}
		});
		
		for (String k : m.keySet()) {
			pq.add(k);
		}
		
		while (!pq.isEmpty()) {
			List<String> list = new ArrayList<String>();
			Set<String> ids = new HashSet<String>();
			while (list.size() < pageSize) {
				if (!pq.isEmpty()) {
					String id = pq.poll();
					LinkedList<Entry> entryList = m.get(id);
					Entry e = entryList.poll();
					list.add(e.listing);
					if (entryList.size() > 0) ids.add(id);
				} else {
					if (ids.isEmpty()) break;	// at the last page
					
					pq.addAll(ids);
					ids = new HashSet<String>();
				}
			}
			
			result.add(list);
			if (!ids.isEmpty()) pq.addAll(ids);
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("1,28,310.6,SF");
		input.add("4,5,204.1,SF");
		input.add("20,7,203.2,Oakland");
		input.add("6,8,202.2,SF");
		input.add("6,10,199.1,SF");
		input.add("1,16,190.4,SF");
		input.add("6,29,185.2,SF");
		input.add("7,20,180.1,SF");
		input.add("6,21,162.1,SF");
		input.add("2,18,161.2,SF");
		input.add("2,30,149.1,SF");
		input.add("3,76,146.2,SF");
		input.add("2,14,141.1,San Jose");

		int pageSize = 5;

		Pagination h = new Pagination();
		
//		List<String> result = h.displayPages(input, pageSize); 
//		int i = 0;
//		for (String s : result) {
//			System.out.println(s);
//			i++;
//			if (i % pageSize == 0) {
//				System.out.println("-----------------------------");
//			}
//		}
		
		List<List<String>> res = h.pagination(input, pageSize);
		for (List<String> list : res) {
			for (String s : list) {
				System.out.println(s);
			}
			System.out.println("-----------------------------");
		}
		
	}
}
