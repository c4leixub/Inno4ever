package com.fcb.greedy;

/**
 * You are driving a vehicle that has capacity empty seats initially available
 * for passengers. The vehicle only drives east (ie. it cannot turn around and
 * drive west.)
 * 
 * Given a list of trips, trip[i] = [num_passengers, start_location,
 * end_location] contains information about the i-th trip: the number of
 * passengers that must be picked up, and the locations to pick them up and drop
 * them off. The locations are given as the number of kilometers due east from
 * your vehicle's initial location.
 * 
 * Return true if and only if it is possible to pick up and drop off all
 * passengers for all the given trips.
 * 
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4 Output: false
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5 Output: true
 */
public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {

		int end = 0;
		for (int[] trip : trips) {
			end = Math.max(end, trip[2]);
		}

		int[] reqCapacity = new int[end + 1];
		for (int[] trip : trips) {
			for (int i = trip[1]; i < trip[2]; i++) {
				reqCapacity[i] += trip[0];
			}
		}

		for (int i = 0; i <= end; i++) {
			if (reqCapacity[i] > capacity) {
				return false;
			}
		}

		return true;
	}
}
