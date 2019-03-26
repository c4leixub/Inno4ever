package com.abb.abb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> indegree = new HashMap<Character, Integer>();

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char curr = word.charAt(i);
				graph.putIfAbsent(curr, new HashSet<Character>());
				indegree.putIfAbsent(curr, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i], word2 = words[i + 1];

			boolean found = false;
			for (int j = 0; j < word1.length() && j < word2.length(); j++) {
				char from = word1.charAt(j), to = word2.charAt(j);

				if (from == to)
					continue; // 如果相同则继续，找到两个单词第一个不相同的字母

				found = true;
				if (!graph.get(from).contains(to)) {
					graph.get(from).add(to); // 将后面的字母加入前面字母的Set中
					indegree.put(to, indegree.get(to) + 1); // 更新后面字母的计数器，+1
				}
				break;

			}

			// handle case like "wrtkj","wrt, return false.
			if (!found && word1.length() > word2.length()) {
				return "";
			}
		}

		StringBuilder order = new StringBuilder();
		Queue<Character> queue = new LinkedList<Character>();
		for (Character key : indegree.keySet()) {
			if (indegree.get(key) == 0) { // add key with indegree == 0
				queue.offer(key);
			}
		}

		while (!queue.isEmpty()) {
			Character cur = queue.poll();
			order.append(cur);

			Set<Character> set = graph.get(cur);
			if (set != null) {
				for (Character c : set) {
					// decrease the indegree of all the child, until indegree==0
					indegree.put(c, indegree.get(c) - 1);
					if (indegree.get(c) == 0) {
						queue.offer(c);
					}
				}
			}
		}

		return order.length() == indegree.size() ? order.toString() : "";
	}

	public static void main(String[] args) {
		String[] words = new String[] {
				// "wrtkj","wrt"
				// "za","zb","ca","cb"
				"wrt", "wrf", "er", "ett", "rftt", "te" };
		AlienDictionary a = new AlienDictionary();
		System.out.println(a.alienOrder(words));
	}
}
