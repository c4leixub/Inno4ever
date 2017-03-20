package com.zeetcode.google;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class VoteCount {
	public class Vote implements Comparable<Vote> {
		public String name;
		public Timestamp timestamp;
		public Vote(String name, Timestamp timestamp) {
			this.name = name;
			this.timestamp = timestamp;
		}
		@Override
		public int compareTo(Vote o) {
			return this.timestamp.compareTo(timestamp);
		}
	}
		
	
	private Map<String, Integer> voteCounts;
	private Map<Timestamp, Map<String, Integer>> voteCountsByTS;
	private Timestamp min;
	private Timestamp max;
	
	public VoteCount(List<Vote> votes) {
		Collections.sort(votes);
		min = votes.get(0).timestamp;
		max = votes.get(votes.size()-1).timestamp;
		
		voteCounts = new HashMap<String, Integer>();
		voteCountsByTS = new HashMap<Timestamp, Map<String, Integer>>();
		
		for (Vote v : votes) {
			if (voteCounts.containsKey(v.name)) {
				voteCounts.put(v.name, voteCounts.get(v.name) + 1);
			} else {
				voteCounts.put(v.name, 1);
			}
			
			Map<String, Integer> m;
			if (!voteCountsByTS.containsKey(v.timestamp)) {
				m = new HashMap<String, Integer>();
				voteCountsByTS.put(v.timestamp, m);
			}
			m = voteCountsByTS.get(v.timestamp);
			m.put(v.name, voteCounts.get(v.name));
		}
	}
	
	public String findLeadingCandidate(Timestamp timestamp) {
		if (timestamp.before(min)) return "";
		if (timestamp.after(max)) timestamp = max;
		
		String lead = null;
		Map<String, Integer> m = voteCountsByTS.get(timestamp);
		for (String candidate : m.keySet()) {
			if (lead == null || m.get(lead) < m.get(candidate)) {
				lead = candidate;
			} 
		}
		
		return lead;
	}
	
	public List<String> findLeadingCandidates(int k, Timestamp timestamp) {
		List<String> result = new ArrayList<String>();
		
		if (timestamp.before(min)) return result;
		if (timestamp.after(max)) timestamp = max;
		
		
		Map<String, Integer> m = voteCountsByTS.get(timestamp);
		PriorityQueue<String> topK = new PriorityQueue<String>(k,
				new Comparator<String>() {
					public int compare(String o1, String o2) {
						return m.get(o1) - m.get(o2);
					}
		});
		
		for (String candidate : m.keySet()) {
			topK.add(candidate);
			if (topK.size() > k) {
				topK.poll();
			}
		}
		
		result.addAll(topK);
		Collections.reverse(result);
		return result;
	}

	public Timestamp findTimestampByGivenRank(List<String> rank) {
		for (Timestamp ts : voteCountsByTS.keySet()) {
			List<String> rankAtTS = findLeadingCandidates(rank.size(), ts);
			if (rankAtTS.equals(rank)) {
				return ts;
			}
		}
		
		return null;
	}
}
