package com.zeetcode.systemDesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MiniYelp {
	static class Location {
		public double latitude, longitude;

		public static Location create(double lati, double longi) {
			// This will create a new location object
			return null;
		}
	};

	static class Restaurant {
		public int id;
		public String name;
		public Location location;

		public static Restaurant create(String name, Location location) {
			// This will create a new restaurant object,
			// and auto fill id
			return null;
		}
	};

	static class Helper {
		public static double get_distance(Location location1, Location location2) {
			// return distance between location1 and location2.
			return 0.0;
		}
	};

	static class GeoHash {
		public static String encode(Location location) {
			// return convert location to a GeoHash string
			return null;
		}

		public static Location decode(String hashcode) {
			// return convert a GeoHash string to location
			return null;
		}
	};

	private HashMap<Integer, Restaurant> restaurants;
	
	public MiniYelp() {
		restaurants = new HashMap<Integer, Restaurant>();
	}

	// @param name a string
	// @param location a Location
	// @return an integer, restaurant's id
	public int addRestaurant(String name, Location location) {
		Restaurant r = Restaurant.create(name, location);
		restaurants.put(r.id, r);
		return r.id;
	}

	// @param restaurant_id an integer
	public void removeRestaurant(int restaurant_id) {
		restaurants.remove(restaurant_id);
	}

	// @param location a Location
	// @param k an integer, distance smaller than k miles
	// @return a list of restaurant's name and sort by
	// distance from near to far.
	public List<String> neighbors(Location location, double k) {
		// Write your code here
		return null;
	}

}
