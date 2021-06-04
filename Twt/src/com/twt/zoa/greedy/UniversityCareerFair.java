package com.twt.zoa.greedy;

public class UniversityCareerFair {
	
	public int maxEvent(int[] arrival, int[] duration) {
		
		int n = arrival.length;
		int[][] intervals = new int[n][2];
		for (int i = 0; i < n; i++) {
			intervals[i] = new int[] {arrival[i], arrival[i] + duration[i]};
		}
		
		int events = 0;
		int[] event = intervals[0], cur;
		for (int i = 1; i < n; i++) {
			cur = intervals[i];
			if (event[1] <= cur[0]) {
				events++;
				event = cur;
			} else {
				event[1] = Math.max(event[1], cur[1]);
			}
		}
		events++;
		
		return events;
	}
	
	public static void main(String[] args) {
		UniversityCareerFair u = new UniversityCareerFair();
		
		int[] arrivals = new int[] {1,3,3,5,7};
		int[] duration = new int[] {2,2,1,2,1};
		
		System.out.println(u.maxEvent(arrivals, duration));
		
	}
}
