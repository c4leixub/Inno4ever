package com.twt.zpdm.eventstats;

import java.util.*;

public class UserActiveMinute {

	public List<Integer> getUserActiveMinuteHistogram(long[][] logs, int intervalSize) {
		List<Integer> res = new ArrayList<>();
		Map<Long, Set<Long>> idToTS = new HashMap<>(); // id to timestamps

		int maxMinutes = 0;
		Set<Long> s;
		for (long[] log : logs) {
			s = idToTS.get(log[0]);
			if (s == null) {
				s = new HashSet<>();
				idToTS.put(log[0], s);
			}

			s.add(log[1]);
			maxMinutes = Math.max(s.size(), maxMinutes);
		}

		int size = maxMinutes / intervalSize + 1;
		for (int i = 0; i < size; i++) {
			res.add(0);
		}

		int index;
		for (Map.Entry<Long, Set<Long>> entry : idToTS.entrySet()) {
			index = entry.getValue().size() / intervalSize;
			res.set(index, res.get(index) + 1);
		}

		return res;
	}

	// LC 1817
	public int[] findingKthUsersActiveMinutes(int[][] logs, int k) {
		Map<Integer, Set<Integer>> idToTimes = new HashMap<>();
		int[] res = new int[k];

		int size;
		boolean isAdded;
		Set<Integer> set;
		for (int[] log : logs) {
			set = idToTimes.get(log[0]);
			if (set == null) {
				set = new HashSet<>();
				idToTimes.put(log[0], set);
			}

			isAdded = set.add(log[1]);
			
			size = set.size();
			if (isAdded && size <= k + 1) {
				if (size != 1)
					res[size - 2]--;
				if (size != k + 1)
					res[size - 1]++;
			}
		}

		return res;
	}

	public List<Integer> getUserActiveMinuteHistogram2(long[][] logs, int intervalSize) {

		List<Integer> res = new ArrayList<>();
		Map<Long, Set<Long>> idToTimestamps = new HashMap<>();
		Map<Integer, Set<Long>> intervalToIds = new HashMap<>();

		int index;
		boolean isAdded;
		Set<Long> ts, ids;
		for (long[] log : logs) {
			ts = idToTimestamps.get(log[0]);
			if (ts == null) {
				ts = new HashSet<>();
				idToTimestamps.put(log[0], ts);
			}

			isAdded = ts.add(log[1]);

			if (isAdded) {
				index = ts.size() / intervalSize;
				ids = intervalToIds.get(index);
				if (ids == null) {
					ids = new HashSet<>();
					intervalToIds.put(index, ids);
					res.add(0);
				}

				isAdded = ids.add(log[0]);
				if (isAdded) {
					res.set(index, res.get(index) + 1);
					if (index != 0) {
						intervalToIds.get(index - 1).remove(log[0]);
						res.set(index - 1, res.get(index - 1) - 1);
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		long[][] logs = new long[][] { { 1, 1518290973 }, { 2, 1518291032 }, { 3, 1518291095 }, { 1, 1518291096 },
				{ 4, 1518291120 }, { 3, 1518291178 }, { 1, 1518291200 }, { 1, 1518291200 } };

		UserActiveMinute u = new UserActiveMinute();
		System.out.println(u.getUserActiveMinuteHistogram2(logs, 2));
	}
}
