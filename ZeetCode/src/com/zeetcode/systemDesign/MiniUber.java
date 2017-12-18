package com.zeetcode.systemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MiniUber {
	public class Trip {
		public int id; // trip's id, primary key
		public int driver_id, rider_id; // foreign key
		public double lat, lng; // pick up location

		public Trip(int rider_id, double lat, double lng) {

		}
	}
	
	public static class Helper {
		public static double get_distance(double lat1, double lng1, double lat2, double lng2) {
		// return distance between (lat1, lng1) and (lat2, lng2)
		return 0.0;
		}
	}
	
	public class Loc {
		public double lat, lng; // driver location
		public Loc(double _lat, double _lng) {
            lat = _lat;
            lng = _lng;
        }
	}

	private Map<Integer, Trip> driverTrip;
	private Map<Integer, Loc> driverLoc;
	private Set<Trip> requests;

	public MiniUber() {
		driverTrip = new HashMap<Integer, Trip>();
		driverLoc = new HashMap<Integer, Loc>();
		requests = new HashSet<Trip>();
	}

	// @param driver_id an integer
	// @param lat, lng driver's location
	// return matched trip information if there have matched rider or null
	public Trip report(int driver_id, double lat, double lng) {
		if (driverTrip.containsKey(driver_id)) {
			return driverTrip.get(driver_id);
		}
		
		if (driverLoc.containsKey(driver_id)) {
            driverLoc.get(driver_id).lat = lat;
            driverLoc.get(driver_id).lng = lng;
        } else {
            driverLoc.put(driver_id, new Loc(lat, lng));
        }
        
        return null;
	}

	// @param rider_id an integer
	// @param lat, lng rider's location
	// return a trip
	public Trip request(int rider_id, double lat, double lng) {
		Integer closeDriverId = null;
		double closeDistance = Double.MAX_VALUE;
		double distance;
		Loc location;
		for (Integer driverId : driverLoc.keySet()) {
			location = driverLoc.get(driverId);
			distance = Helper.get_distance(lat, lng, location.lat, location.lng);

			if (closeDriverId == null || distance < closeDistance) {
				closeDriverId = driverId;
				closeDistance = distance;
			}
		}

		Trip trip = new Trip(rider_id, lat, lng);
		if (closeDriverId != null) {
			driverLoc.remove(closeDriverId);
			
			trip.driver_id = closeDriverId;
			driverTrip.put(closeDriverId, trip);
		}

		return trip;
	}
}
