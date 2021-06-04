package com.twt.ltc.unionfind;

import java.util.*;

public class AccountMerger {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> result = new ArrayList<List<String>>();

		// email to indexes
		Map<String, Set<Integer>> map = new HashMap<>();

		Set<Integer> indexes;
		List<String> list;
		String email;
		for (int i = 0; i < accounts.size(); i++) {
			list = accounts.get(i);
			for (int j = 1; j < list.size(); j++) {
				email = list.get(j);
				indexes = map.get(email);
				if (indexes == null) {
					indexes = new HashSet<>();
					map.put(email, indexes);
				}
				indexes.add(i);
			}
		}

		Set<String> emails;
		Queue<Integer> queue;
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < accounts.size(); i++) {
			if (visited.contains(i))
				continue;

			emails = new HashSet<String>();

			queue = new LinkedList<Integer>();
			queue.add(i);

			while (!queue.isEmpty()) {
				Integer index = queue.poll();
				visited.add(index);

				for (int j = 1; j < accounts.get(index).size(); j++) {
					email = accounts.get(index).get(j);
					emails.add(email);

					for (Integer idx : map.get(email)) {
						if (visited.contains(idx))
							continue;
						queue.add(idx);
						visited.add(idx);
					}

				}
			}

			addToResult(result, emails, accounts.get(i).get(0));
		}

		return result;
	}

	private void addToResult(List<List<String>> result, Set<String> emails, String name) {
		List<String> list = new ArrayList<String>();
		list.add(name);
		list.addAll(emails);
		Collections.sort(list);
		result.add(list);
	}
}
