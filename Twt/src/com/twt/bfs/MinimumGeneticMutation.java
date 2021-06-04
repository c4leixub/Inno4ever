package com.twt.bfs;

import java.util.*;

public class MinimumGeneticMutation {
	char[] choices = new char[] { 'A', 'C', 'G', 'T' };

	public int minMutation(String start, String end, String[] bank) {

		Set<String> b = new HashSet<>();
		for (String s : bank) {
			b.add(s);
		}

		Queue<String> q = new LinkedList<String>();
		Queue<Integer> m = new LinkedList<Integer>();

		q.add(start);
		m.add(0);

		String gene;
		Integer mutate;
		while (!q.isEmpty()) {
			gene = q.poll();
			mutate = m.poll();

			if (gene.equals(end)) {
				return mutate;
			}

			if (b.isEmpty()) {
				continue;
			}

			nextGene(gene, mutate, q, m, b);
		}

		return -1;
	}

	private void nextGene(String gene, Integer mutate, Queue<String> q, Queue<Integer> m, Set<String> b) {
		String nextGene;
		char t;
		char[] s = gene.toCharArray();
		for (int i = 0; i < s.length; i++) {
			t = gene.charAt(i);
			for (char c : choices) {
				if (c != t) {
					s[i] = c;
				}
				nextGene = new String(s);

				if (b.contains(nextGene)) {
					q.add(nextGene);
					m.add(mutate + 1);
					b.remove(nextGene);
				}
			}
			s[i] = t;
		}
	}
}
