package com.zeetcode.airbnb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.zeetcode.node.ListNode;

/**
 * You’re given an array of CSV strings representing search results. Results are
 * sorted by a score initially. A given host may have several listings that show
 * up in these results. Suppose we want to show 12 results per page, but we
 * don’t want the same host to dominate the results. Write a function that will
 * reorder the list so that a host shows up at most once on a page if possible,
 * but otherwise preserves the ordering. Your program should return the new
 * array and print out the results in blocks representing the pages.
 * 
 * Input: * An array of csv strings, with sort score * number of results per
 * page
 * 
 */
public class HostCrowding {
	public static void main(String[] args) {
		int PER_PAGE = 12;
		List<String> input = new ArrayList<String>();

		// input.add("host_id,listing_id,score,city");
		input.add("1,28,300.1,San Francisco");
		input.add("4,5,209.1,San Francisco");
		input.add("20,7,208.1,San Francisco");
		input.add("23,8,207.1,San Francisco");
		input.add("16,10,206.1,Oakland");
		input.add("1,16,205.1,San Francisco");
		input.add("6,29,204.1,San Francisco");
		input.add("7,20,203.1,San Francisco");
		input.add("8,21,202.1,San Francisco");
		input.add("2,18,201.1,San Francisco");
		input.add("2,30,200.1,San Francisco");
		input.add("15,27,109.1,Oakland");
		input.add("10,13,108.1,Oakland");
		input.add("11,26,107.1,Oakland");
		input.add("12,9,106.1,Oakland");
		input.add("13,1,105.1,Oakland");
		input.add("22,17,104.1,Oakland");
		input.add("1,2,103.1,Oakland");
		input.add("28,24,102.1,Oakland");
		input.add("18,14,11.1,San Jose");
		input.add("6,25,10.1,Oakland");
		input.add("19,15,9.1,San Jose");
		input.add("3,19,8.1,San Jose");
		input.add("3,11,7.1,Oakland");
		input.add("27,12,6.1,Oakland");
		input.add("1,3,5.1,Oakland");
		input.add("25,4,4.1,San Jose");
		input.add("5,6,3.1,San Jose");
		input.add("29,22,2.1,San Jose");
		input.add("30,23,1.1,San Jose");

		HostCrowding h = new HostCrowding();
		List<List<String>> result;
		// result = h.hostCrowding(input, PER_PAGE);
		// print(result);

		input = new ArrayList<String>();
		input.add("1,");
		input.add("2,");
		input.add("3,");
		input.add("4,");
		input.add("1,");
		input.add("5,");
		input.add("1,");
		input.add("2,");
		input.add("3,");
		input.add("1,");
		input.add("3,");
		System.out.println(input.size());
		result = h.hostCrowding(input, 5);
		print(result);
		result = h.hostCrowding3(input, 5);
		print(result);

//		input = new ArrayList<String>();
//		input.add("1,28,310.6,SF");
//		input.add("4,5,204.1,SF");
//		input.add("20,7,203.2,Oakland");
//		input.add("6,8,202.2,SF");
//		input.add("6,10,199.1,SF");
//		input.add("1,16,190.4,SF");
//		input.add("6,29,185.2,SF");
//		input.add("7,20,180.1,SF");
//		input.add("6,21,162.1,SF");
//		input.add("2,18,161.2,SF");
//		input.add("2,30,149.1,SF");
//		input.add("3,76,146.2,SF");
//		input.add("2,14,141.1,San Jose");
//		System.out.println(input.size());
//		result = h.hostCrowding(input, 5);
//		print(result);
//		result = h.hostCrowding3(input, 5);
//		print(result);
	}

	public List<List<String>> hostCrowding(List<String> input, int perPage) {
		List<List<String>> result = new ArrayList<List<String>>();

		Map<Integer, LinkedList<Integer>> idToIndexes = new HashMap<Integer, LinkedList<Integer>>();
		int hostId;
		for (int i = 0; i < input.size(); i++) {
			hostId = parseHostId(input.get(i));
			if (!idToIndexes.containsKey(hostId)) {
				idToIndexes.put(hostId, new LinkedList<Integer>());
			}
			idToIndexes.get(hostId).add(i);
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(idToIndexes.size(), new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return idToIndexes.get(o1).peek() - idToIndexes.get(o2).peek();
			}
		});
		for (Integer id : idToIndexes.keySet()) {
			queue.add(id);
		}

		List<String> page = new ArrayList<String>();
		Set<Integer> visited = new HashSet<Integer>();
		while (!idToIndexes.isEmpty()) {
			int nextId = queue.poll();
			page.add(input.get(idToIndexes.get(nextId).poll()));

			visited.add(nextId);

			if (page.size() == perPage || queue.isEmpty()) {
				for (Integer id : visited) {
					if (!idToIndexes.get(id).isEmpty()) {
						queue.add(id);
					} else {
						idToIndexes.remove(id);
					}
				}
				visited.clear();

				if (page.size() == perPage) {
					result.add(page);
					page = new ArrayList<String>();
				} else if (page.size() < perPage) {
					// most once is not possible, next loop to preserve order
					break;
				}
			}
		}

		while (!idToIndexes.isEmpty()) {
			int nextId = queue.poll();
			page.add(input.get(idToIndexes.get(nextId).poll()));
			if (page.size() == perPage) {
				result.add(page);
				page = new ArrayList<String>();
			}
			if (!idToIndexes.get(nextId).isEmpty()) {
				queue.add(nextId);
			} else {
				idToIndexes.remove(nextId);
			}
		}

		// last non-full page left out, add to result
		if (!page.isEmpty()) {
			result.add(page);
		}

		return result;
	}
	
	public List<List<String>> hostCrowding2(List<String> input, int perPage) {
		int i = 1;
		Map<Integer, List<String>> pages = displayPages(input, perPage);
		List<List<String>> result = new ArrayList<List<String>>();
		while (pages.containsKey(i)) {
			result.add(pages.get(i));
			i++;
		}
		return result;
	}

	public Map<Integer, List<String>> displayPages(List<String> input, int perPage) {
		// Map Solution
		Map<Integer, List<String>> result = new HashMap<>();
		
		Map<String, Integer> hostIdToPageNum = new HashMap<>();
		for (int i = 0; i < input.size(); i++) {
			String[] logItems = input.get(i).split(",");
			
			// get the page num
			int pageNum = hostIdToPageNum.getOrDefault(logItems[0], 0) + 1;
			while (result.containsKey(pageNum) && result.get(pageNum).size() == perPage) {
				pageNum++;
			}
			
			result.putIfAbsent(pageNum, new ArrayList<>());
			result.get(pageNum).add(input.get(i));
			
			hostIdToPageNum.put(logItems[0], pageNum);
		}
		return result;
	}

	private int parseHostId(String line) {
		return Integer.parseInt(line.substring(0, line.indexOf(",")));
	}

	public static void print(List<List<String>> result) {
		int p = 0;
		for (List<String> list : result) {
			System.out.print("Page " + p + ": ");
			System.out.println(list);
			System.out.println(list.size());
			// for (String s: list) {
			// System.out.println(s);
			// }
			p++;
		}
	}
	
	public List<List<String>> hostCrowding3(List<String> input, int perPage) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		int pages = input.size() / perPage;
		if (input.size() % perPage != 0) pages++;
		for (int i = 0; i < pages; i++) {
			result.add(new ArrayList<String>());
		}
		
		boolean[] visited = new boolean[input.size()];
		
		Set<Integer> visitedId = new HashSet<Integer>();
		int p = 0;
		int hostId;
		while (p < pages) {
			for (int i = 0; i < input.size() && result.get(p).size() < perPage; i++) {
				hostId = parseHostId(input.get(i));
				if (!visited[i] && !visitedId.contains(hostId)) {
					result.get(p).add(input.get(i));
					visited[i] = true;
					visitedId.add(hostId);
				}
			}
			
			visitedId.clear();
			if (result.get(p).size() == perPage) {
				p++;
			} else {
				// most once is not possible, next loop to preserve order
				break;
			}
		}
		
		if (p < pages) {
			for (int i = 0; i < input.size(); i++) {
				if (!visited[i]) {
					result.get(p).add(input.get(i));
				}
				if (result.get(p).size() == perPage) {
					p++;
				}
			}
		}
		
		return result;
	}

}
